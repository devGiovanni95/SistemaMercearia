--Triggers 

CREATE TRIGGER TG_ADICIONAR_ESTOQUE_INSERT
ON tb_produto_fornecedor
FOR INSERT
AS
BEGIN
	DECLARE @QUANTIDADE DECIMAL(10,3),
			@CODIGO VARCHAR(13)

	SELECT @QUANTIDADE = quantidade, 
	@CODIGO = COD_PRODUTO FROM INSERTED
	
	UPDATE tb_produto
	SET quantidade = quantidade + @QUANTIDADE 
	WHERE codigo_barras = @CODIGO;
END;





--trigger para dar saida na quantidade de produtos no estoque 


CREATE TRIGGER TG_BAIXA_ESTOQUE_INSERT
ON tb_item_venda
FOR INSERT
AS
BEGIN
	DECLARE @QUANTIDADE DECIMAL(10,3),
			@CODIGO VARCHAR(13)

	SELECT @QUANTIDADE = quantidade_produto, 
	@CODIGO = CODIGO_PRODUTO FROM INSERTED
	
	UPDATE tb_produto
	SET quantidade = quantidade - @QUANTIDADE 
	WHERE codigo_barras = @CODIGO;
END;
