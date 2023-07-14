package com.menezesdev.services.validation;

import com.menezesdev.controller.Execpetion.FieldMessage;
import com.menezesdev.dto.ClienteNewDTO;
import com.menezesdev.models.Cliente;
import com.menezesdev.models.enums.TipoCliente;
import com.menezesdev.repositories.ClienteRepository;
import com.menezesdev.services.validation.utils.BR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    public ClienteRepository clienteRepository;
    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        Cliente auxcliente = clienteRepository.findByEmail(objDto.getEmail());
        if(auxcliente != null)
        {
            list.add(new FieldMessage("email", "Email já existente" ));
        }
        // inclua os testes aqui, inserindo erros na lista

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldname()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}