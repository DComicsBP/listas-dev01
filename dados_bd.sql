use lista03; 
create database lista03; 
select * FROM autor;

select * from telefone;	 
select * from usuario_telefone	; 
select * from editora;
select * from livro;		
select * from livro_autor;
select * from autor where sobrenome = 'sobrenome106';
select * from livro_editora; 
select * from bibliotecario;
select * from usuario; 	
select * from emprestimo; 	
	
alter table emprestimo drop reiurada ;
INSERT INTO `lista03`.`emprestimo` (`devolucao_previsao`, `bibliotecario_id`, `livro_id`, `usuario_id`, `retirada`) VALUES ('2018-10-02', '1', '5', '1', '2018-10-01');
delete from emprestimo; 
  
delete from livro where id= 12; 
INSERT INTO `lista03`.`Autor` (`nome`, `sobrenome`) VALUES ('Joao ', 'Silva');
INSERT INTO `lista03`.`Autor` (`nome`, `sobrenome`) VALUES ('Rafael', 'Luz');

INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1991, 1,'TITULO 01');
INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1992, 1,'TITULO 02');
INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1993, 1,'TITULO 03');
INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1994, 1,'TITULO 04');
INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1995, 1,'TITULO 05');


INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (5,22,111111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (6,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (7,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (8,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (9,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (10,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (11,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (12,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (13,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (14,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (15,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`usexr_id`) VALUES (16,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (17,22,991111222,733,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (18,42,211111222,533,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (19,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (20,22,991111222,733,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (21,42,211111222,533,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (22,2111,41111222,333,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (23,22,991111222,733,'1',9);
INSERT INTO `telefone` (`id`,`area`,`numero`,`ramal`,`tipo`,`user_id`) VALUES (24,42,211111222,533,'1',9);

INSERT INTO `lista03`.`livro` (`ano_publicacao`, `doacao`, `titulo`) VALUES (1998, 0, 'TITULO 03');


INSERT INTO `lista03`.`emprestimo` (`devolucao_previsao`, `devoulucao`, `bibliotecario_id`, `livro_id`, `usuario_id`, `retirada`) VALUES ('2018-12-01', '2018-12-01', '1', '1', '1', '2018-11-16');
