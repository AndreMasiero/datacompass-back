package com.datacompass.enums.errorCode;

public enum ErrorCode {

	//Faixa de 1000 a 1020 são para dados de cadastro de usuários
	USER_EMAIL_UNAVAILABLE("1000", "Já existe um usuário cadastrado com este e-mail.", ""),
	USER_FIRST_NAME_AND_LAST_NAME_UNAVAILABLE("1001", "Já existe um usuário cadastrado com este nome e sobrenome.", ""),
	USER_NAME_UNAVAILABLE("1002", "Já existe um usuário com este username", "");

	/** Código do erro */
	private final String code;

	/** Descrição do erro (técnico). */
	private final String description;

	/** Comentários */
	private final String comments;
	
	private ErrorCode(String code, String description, String comments) {
		this.code = code;
		this.description = description;
		this.comments = comments;
	}

	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	public String getComments() {
		return comments;
	}
}