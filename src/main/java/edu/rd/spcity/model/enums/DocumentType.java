package edu.rd.spcity.model.enums;

import lombok.Getter;

@Getter
public enum DocumentType {
    PASSPORT("Паспорт"),
    FOREIGN_PASSPORT("Паспорт (иностранца)"),
    BIRTH_CERTIFICATE("Свидетельство о рождении"),
    MVD_PASSPORT("Паспорт (работника МВД)");

    private final String name;

    DocumentType(String name) {
        this.name = name;
    }
}
