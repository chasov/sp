package edu.rd.spcity.model.enums;

import lombok.Getter;

@Getter
public enum AddressRegistrationType {
    LIVING_IN_CURRENT_ADDRESS("Прописан по данному адресу"),
    LIVING_IN_OTHER_ADDRESS("Прописан по другому адресу"),
    INDIVIDUAL_ENTREPRENEUR("Индивидуальный частный предприниматель");

    private final String name;

    AddressRegistrationType(String name) {
        this.name = name;
    }
}
