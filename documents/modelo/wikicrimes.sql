/**
 
    WikiCrimes (http://www.wikicrimes.org) is a project/software that allows posting and accessing criminal occurrences in a digital map.
    The philosophy that drives Wikicrimes is the same as Wikipedia: mass collaboration produces valuable knowledge.
    That is to say, if everybody participates, the criminal mapping will be made collaboratively and everybody
    will leverage crime information digitalized in the map. That is the reason for the slogan "Share crime information. Keep safe!". 
    Wikicrimes is not a project developed by any security institution. 
    In fact it is a project from the citizen to the citizen. 
     
    
    Copyright (C) 2008  Wikinova Solutions (http://www.wikinova.com.br)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

CREATE TABLE TB_TTR_TIPO_TRANSPORTE (
  TTR_IDTIPO_TRANSPORTE BIGINT NOT NULL AUTO_INCREMENT,
  TTR_NOME VARCHAR(255) NULL,
  TTR_DESCRICAO TEXT NULL,
  PRIMARY KEY(TTR_IDTIPO_TRANSPORTE)
);

INSERT INTO TB_TTR_TIPO_TRANSPORTE(TTR_IDTIPO_TRANSPORTE, TTR_NOME, TTR_DESCRICAO) 
VALUES 
(1, "Moto", ""), 
(2, "Carro", ""), 
(3, "Bicicleta", ""), 
(4, "A p�", ""),
(5, "Outros", "");


CREATE TABLE TB_TRE_TIPO_REGISTRO (
  TRE_IDTIPO_REGISTRO BIGINT NOT NULL AUTO_INCREMENT,
  TRE_NOME VARCHAR(255) NOT NULL,
  TRE_DESCRICAO TEXT NULL,
  PRIMARY KEY(TRE_IDTIPO_REGISTRO)
);

INSERT INTO TB_TRE_TIPO_REGISTRO(TRE_IDTIPO_REGISTRO, TRE_NOME, TRE_DESCRICAO)
VALUES
(1, "Sim - 190", ""),
(2, "Sim - Delegacia", ""),
(3, "N�o", ""),
(4, "N�o Sei", "");


CREATE TABLE TB_TPA_TIPO_PAPEL (
  TPA_IDTIPO_PAPEL BIGINT NOT NULL AUTO_INCREMENT,
  TPA_NOME VARCHAR(255) NULL,
  TPA_DESCRICAO TEXT NULL,
  PRIMARY KEY(TPA_IDTIPO_PAPEL)
);

INSERT INTO TB_TPA_TIPO_PAPEL(TPA_IDTIPO_pAPEL, TPA_NOME, TPA_DESCRICAO)  
VALUES  
(1, "V�tima", ""),  
(2, "Testemunha", ""),  
(3, "Nenhuma, apenas ouvir falar", "");


CREATE TABLE TB_TCR_TIPO_CRIME (
  TCR_IDTIPO_CRIME BIGINT NOT NULL AUTO_INCREMENT,
  TCR_NOME VARCHAR(255) NOT NULL,
  TCR_DESCRICAO TEXT NULL,
  PRIMARY KEY(TCR_IDTIPO_CRIME)
);

INSERT INTO TB_TCR_TIPO_CRIME(TCR_IDTIPO_CRIME, TCR_NOME, TCR_DESCRICAO)
VALUES
(1, 'Tentativa de Roubo', 'Descri��o de Furto'),
(2, 'Tentativa de Furto', 'Descri��o de Furto'),
(3, 'Furto', 'Descri��o de Furto'),
(4, 'Roubo', 'Descri��o de Furto'),
(5, 'Consumo ou Tr�fico de Drogas', 'Descri��o de Furto'),
(6, 'Brigas', 'Descri��o de Furto');


CREATE TABLE TB_USU_USUARIO (
  USU_IDUSUARIO BIGINT NOT NULL AUTO_INCREMENT,
  USU_PRIMEIRO_NOME VARCHAR(255) NOT NULL,
  USU_HOMEPAGE VARCHAR(255) NULL,
  USU_EMAIL VARCHAR(255) NULL,
  USU_LOGIN VARCHAR(30) NOT NULL,
  USU_SENHA VARCHAR(255) NOT NULL,
  USU_ESTADO VARCHAR(30) NULL,
  USU_PAIS VARCHAR(30) NULL,
  USU_ANIVERSARIO DATE NULL,
  USU_IP VARCHAR(255) NULL,
  USU_CIDADE VARCHAR(255) NULL,
  USU_ULTIMO_NOME VARCHAR(255) NOT NULL,
  PRIMARY KEY(USU_IDUSUARIO)
);

CREATE TABLE TB_TVI_TIPO_VITIMA (
  TVI_IDTIPO_VITIMA BIGINT NOT NULL AUTO_INCREMENT,
  TVI_NOME VARCHAR(255) NULL,
  TVI_DESCRICAO TEXT NULL,
  PRIMARY KEY(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TVI_TIPO_VITIMA (TVI_IDTIPO_VITIMA, TVI_NOME, TVI_DESCRICAO)
VALUES
(1, 'Pessoa', ''),
(2, 'Propriedade', '') ;


CREATE TABLE TB_TAU_TIPO_ARMA_USADA (
  TAU_IDTIPO_ARMA_USADA INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  TAU_NOME VARCHAR(255) NOT NULL,
  TAU_DESCRICAO TEXT NULL,
  PRIMARY KEY(TAU_IDTIPO_ARMA_USADA)
);

INSERT INTO TB_TAU_TIPO_ARMA_USADA(TAU_IDTIPO_ARMA_USADA, TAU_NOME, TAU_DESCRICAO)
VALUES
(1, "N�o", ""),
(2, "Fogo", ""),
(3, "Branca", ""),
(4, "Outros", "");


CREATE TABLE TB_TLO_TIPO_LOCAL (
  TLO_IDTIPO_LOCAL BIGINT NOT NULL AUTO_INCREMENT,
  TVI_IDTIPO_VITIMA BIGINT NOT NULL,
  TLO_NOME VARCHAR(255) NOT NULL,
  TLO_DESCRICAO TEXT NULL,
  PRIMARY KEY(TLO_IDTIPO_LOCAL),
  INDEX TB_TLO_TIPO_LOCAL_FKIndex1(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TLO_TIPO_LOCAL(TLO_IDTIPO_LOCAL, TVI_IDTIPO_VITIMA, TLO_NOME, TLO_DESCRICAO)  
VALUES 
(1, 1, 'Via P�blica', ''),    
(2, 1, 'Dentro de Ve�culo', ''),    
(3, 1, 'Estabelecimento Comercial', ''),    
(4, 1, 'Resid�ncia', ''),    
(5, 1, 'Escolas', ''),   
(6, 1, 'Outros', ''),    
(7, 2, 'Resid�ncia', ''),  
(8, 2, 'Banco', ''),  
(9, 2, 'Farm�cia', ''),  
(10, 2, 'Posto de Gasolina', ''),  
(11, 2, 'Lot�rica', ''),  
(12, 2, 'Ve�culo', ''),  
(13, 2, 'Resid�ncia', ''),  
(14, 2, 'DVD/CD/Toca-Fitas', ''),  
(15, 2, 'Outros', ''); 


CREATE TABLE TB_TCV_CRIME_VITIMA (
  TCR_IDTIPO_CRIME BIGINT NOT NULL,
  TVI_IDTIPO_VITIMA BIGINT NOT NULL,
  PRIMARY KEY(TCR_IDTIPO_CRIME, TVI_IDTIPO_VITIMA),
  INDEX TB_TCV_CRIME_VITIMA_FKIndex1(TCR_IDTIPO_CRIME),
  INDEX TB_TCV_CRIME_VITIMA_FKIndex2(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TCV_CRIME_VITIMA(TCR_IDTIPO_CRIME, TVI_IDTIPO_VITIMA)
VALUES  
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1), 
(3, 2),
(4, 1), 
(4, 2);


CREATE TABLE TB_CRI_CRIME (
  CRI_IDCRIME BIGINT NOT NULL AUTO_INCREMENT,
  TLO_IDTIPO_LOCAL BIGINT,
  TCR_IDTIPO_CRIME BIGINT NOT NULL,
  TPA_IDTIPO_PAPEL BIGINT NOT NULL,
  TTR_IDTIPO_TRANSPORTE BIGINT NOT NULL,
  TAU_IDTIPO_ARMA_USADA INTEGER UNSIGNED NOT NULL,
  TRE_IDTIPO_REGISTRO BIGINT NOT NULL,
  USU_IDUSUARIO BIGINT NOT NULL,
  CRI_DATA DATE NOT NULL,
  CRI_QUANTIDADE INTEGER UNSIGNED NULL,
  CRI_FAIXA_ETARIA INTEGER UNSIGNED NULL,
  CRI_QTD_MASCULINO INTEGER UNSIGNED NULL,
  CRI_QTD_FEMININO INTEGER UNSIGNED NULL,
  CRI_SEXO INT(1) NULL,
  CRI_DESCRICAO TEXT NULL,
  CRI_LATITUDE DOUBLE NOT NULL,
  CRI_LONGITUDE DOUBLE NOT NULL,
  CRI_CONFIRMADO INT(1) NULL,
  PRIMARY KEY(CRI_IDCRIME),
  INDEX TB_CRI_CRIME_FKIndex1(USU_IDUSUARIO),
  INDEX TB_CRI_CRIME_FKIndex2(TRE_IDTIPO_REGISTRO),
  INDEX TB_CRI_CRIME_FKIndex3(TAU_IDTIPO_ARMA_USADA),
  INDEX TB_CRI_CRIME_FKIndex4(TTR_IDTIPO_TRANSPORTE),
  INDEX TB_CRI_CRIME_FKIndex5(TPA_IDTIPO_PAPEL),
  INDEX TB_CRI_CRIME_FKIndex6(TCR_IDTIPO_CRIME),
  INDEX TB_CRI_CRIME_FKIndex7(TLO_IDTIPO_LOCAL)
);

CREATE TABLE TB_CON_CONFIRMACAO (
  CON_IDCONFIRMACAO BIGINT NOT NULL AUTO_INCREMENT,
  CRI_IDCRIME BIGINT NOT NULL,
  CON_COMENTARIO TEXT NULL,
  CON_CONFIRMA INT(1) NULL,
  CON_EMAIL VARCHAR(255) NOT NULL,
  CON_NOME VARCHAR(255) NULL,
  CON_DATA_CONFIRMACAO DATE NULL,
  CON_DATA_ENVIO DATE NOT NULL,
  CON_CHAVE_CONFIRMACAO VARCHAR(255) NULL,
  PRIMARY KEY(CON_IDCONFIRMACAO),
  INDEX TB_CON_CONFIMACAO_FKIndex1(CRI_IDCRIME)
);

-- Script para a inclus�o dos subtipos de viol�ncias

insert into tb_tcv_crime_vitima values(5,6),(5,7), (5,8);
insert into tb_tvi_tipo_vitima values(6,'Homic�dio',''),(7,'Tentantiva de Homic�dio',''), (8,'Latroc�nio','');

-- Script para a inclus�o dos subtipos de viol�ncias

-- Script de perfil certificador 
insert into tb_per_perfil values(4,'CERTIFICADOR',null);
-- Script de perfil certificador
CREATE TABLE TB_TTR_TIPO_TRANSPORTE (
  TTR_IDTIPO_TRANSPORTE BIGINT NOT NULL AUTO_INCREMENT,
  TTR_NOME VARCHAR(255) NULL,
  TTR_DESCRICAO TEXT NULL,
  PRIMARY KEY(TTR_IDTIPO_TRANSPORTE)
);

INSERT INTO TB_TTR_TIPO_TRANSPORTE(TTR_IDTIPO_TRANSPORTE, TTR_NOME, TTR_DESCRICAO) 
VALUES 
(1, "Moto", ""), 
(2, "Carro", ""), 
(3, "Bicicleta", ""), 
(4, "A p�", ""),
(5, "Outros", "");


CREATE TABLE TB_TRE_TIPO_REGISTRO (
  TRE_IDTIPO_REGISTRO BIGINT NOT NULL AUTO_INCREMENT,
  TRE_NOME VARCHAR(255) NOT NULL,
  TRE_DESCRICAO TEXT NULL,
  PRIMARY KEY(TRE_IDTIPO_REGISTRO)
);

INSERT INTO TB_TRE_TIPO_REGISTRO(TRE_IDTIPO_REGISTRO, TRE_NOME, TRE_DESCRICAO)
VALUES
(1, "Sim - 190", ""),
(2, "Sim - Delegacia", ""),
(3, "N�o", ""),
(4, "N�o Sei", "");


CREATE TABLE TB_TPA_TIPO_PAPEL (
  TPA_IDTIPO_PAPEL BIGINT NOT NULL AUTO_INCREMENT,
  TPA_NOME VARCHAR(255) NULL,
  TPA_DESCRICAO TEXT NULL,
  PRIMARY KEY(TPA_IDTIPO_PAPEL)
);

INSERT INTO TB_TPA_TIPO_PAPEL(TPA_IDTIPO_pAPEL, TPA_NOME, TPA_DESCRICAO)  
VALUES  
(1, "V�tima", ""),  
(2, "Testemunha", ""),  
(3, "Nenhuma, apenas ouvir falar", "");


CREATE TABLE TB_TCR_TIPO_CRIME (
  TCR_IDTIPO_CRIME BIGINT NOT NULL AUTO_INCREMENT,
  TCR_NOME VARCHAR(255) NOT NULL,
  TCR_DESCRICAO TEXT NULL,
  PRIMARY KEY(TCR_IDTIPO_CRIME)
);

INSERT INTO TB_TCR_TIPO_CRIME(TCR_IDTIPO_CRIME, TCR_NOME, TCR_DESCRICAO)
VALUES
(1, 'Tentativa de Roubo', 'Descri��o de Furto'),
(2, 'Tentativa de Furto', 'Descri��o de Furto'),
(3, 'Furto', 'Descri��o de Furto'),
(4, 'Roubo', 'Descri��o de Furto'),
(5, 'Consumo ou Tr�fico de Drogas', 'Descri��o de Furto'),
(6, 'Brigas', 'Descri��o de Furto');


CREATE TABLE TB_USU_USUARIO (
  USU_IDUSUARIO BIGINT NOT NULL AUTO_INCREMENT,
  USU_PRIMEIRO_NOME VARCHAR(255) NOT NULL,
  USU_HOMEPAGE VARCHAR(255) NULL,
  USU_EMAIL VARCHAR(255) NULL,
  USU_LOGIN VARCHAR(30) NOT NULL,
  USU_SENHA VARCHAR(255) NOT NULL,
  USU_ESTADO VARCHAR(30) NULL,
  USU_PAIS VARCHAR(30) NULL,
  USU_ANIVERSARIO DATE NULL,
  USU_IP VARCHAR(255) NULL,
  USU_CIDADE VARCHAR(255) NULL,
  USU_ULTIMO_NOME VARCHAR(255) NOT NULL,
  PRIMARY KEY(USU_IDUSUARIO)
);

CREATE TABLE TB_TVI_TIPO_VITIMA (
  TVI_IDTIPO_VITIMA BIGINT NOT NULL AUTO_INCREMENT,
  TVI_NOME VARCHAR(255) NULL,
  TVI_DESCRICAO TEXT NULL,
  PRIMARY KEY(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TVI_TIPO_VITIMA (TVI_IDTIPO_VITIMA, TVI_NOME, TVI_DESCRICAO)
VALUES
(1, 'Pessoa', ''),
(2, 'Propriedade', '') ;


CREATE TABLE TB_TAU_TIPO_ARMA_USADA (
  TAU_IDTIPO_ARMA_USADA INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  TAU_NOME VARCHAR(255) NOT NULL,
  TAU_DESCRICAO TEXT NULL,
  PRIMARY KEY(TAU_IDTIPO_ARMA_USADA)
);

INSERT INTO TB_TAU_TIPO_ARMA_USADA(TAU_IDTIPO_ARMA_USADA, TAU_NOME, TAU_DESCRICAO)
VALUES
(1, "N�o", ""),
(2, "Fogo", ""),
(3, "Branca", ""),
(4, "Outros", "");


CREATE TABLE TB_TLO_TIPO_LOCAL (
  TLO_IDTIPO_LOCAL BIGINT NOT NULL AUTO_INCREMENT,
  TVI_IDTIPO_VITIMA BIGINT NOT NULL,
  TLO_NOME VARCHAR(255) NOT NULL,
  TLO_DESCRICAO TEXT NULL,
  PRIMARY KEY(TLO_IDTIPO_LOCAL),
  INDEX TB_TLO_TIPO_LOCAL_FKIndex1(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TLO_TIPO_LOCAL(TLO_IDTIPO_LOCAL, TVI_IDTIPO_VITIMA, TLO_NOME, TLO_DESCRICAO)  
VALUES 
(1, 1, 'Via P�blica', ''),    
(2, 1, 'Dentro de Ve�culo', ''),    
(3, 1, 'Estabelecimento Comercial', ''),    
(4, 1, 'Resid�ncia', ''),    
(5, 1, 'Escolas', ''),   
(6, 1, 'Outros', ''),    
(7, 2, 'Resid�ncia', ''),  
(8, 2, 'Banco', ''),  
(9, 2, 'Farm�cia', ''),  
(10, 2, 'Posto de Gasolina', ''),  
(11, 2, 'Lot�rica', ''),  
(12, 2, 'Ve�culo', ''),  
(13, 2, 'Resid�ncia', ''),  
(14, 2, 'DVD/CD/Toca-Fitas', ''),  
(15, 2, 'Outros', ''); 


CREATE TABLE TB_TCV_CRIME_VITIMA (
  TCR_IDTIPO_CRIME BIGINT NOT NULL,
  TVI_IDTIPO_VITIMA BIGINT NOT NULL,
  PRIMARY KEY(TCR_IDTIPO_CRIME, TVI_IDTIPO_VITIMA),
  INDEX TB_TCV_CRIME_VITIMA_FKIndex1(TCR_IDTIPO_CRIME),
  INDEX TB_TCV_CRIME_VITIMA_FKIndex2(TVI_IDTIPO_VITIMA)
);

INSERT INTO TB_TCV_CRIME_VITIMA(TCR_IDTIPO_CRIME, TVI_IDTIPO_VITIMA)
VALUES  
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 1), 
(3, 2),
(4, 1), 
(4, 2);


CREATE TABLE TB_CRI_CRIME (
  CRI_IDCRIME BIGINT NOT NULL AUTO_INCREMENT,
  TLO_IDTIPO_LOCAL BIGINT,
  TCR_IDTIPO_CRIME BIGINT NOT NULL,
  TPA_IDTIPO_PAPEL BIGINT NOT NULL,
  TTR_IDTIPO_TRANSPORTE BIGINT NOT NULL,
  TAU_IDTIPO_ARMA_USADA INTEGER UNSIGNED NOT NULL,
  TRE_IDTIPO_REGISTRO BIGINT NOT NULL,
  USU_IDUSUARIO BIGINT NOT NULL,
  CRI_DATA DATE NOT NULL,
  CRI_QUANTIDADE INTEGER UNSIGNED NULL,
  CRI_FAIXA_ETARIA INTEGER UNSIGNED NULL,
  CRI_QTD_MASCULINO INTEGER UNSIGNED NULL,
  CRI_QTD_FEMININO INTEGER UNSIGNED NULL,
  CRI_SEXO INT(1) NULL,
  CRI_DESCRICAO TEXT NULL,
  CRI_LATITUDE DOUBLE NOT NULL,
  CRI_LONGITUDE DOUBLE NOT NULL,
  CRI_CONFIRMADO INT(1) NULL,
  PRIMARY KEY(CRI_IDCRIME),
  INDEX TB_CRI_CRIME_FKIndex1(USU_IDUSUARIO),
  INDEX TB_CRI_CRIME_FKIndex2(TRE_IDTIPO_REGISTRO),
  INDEX TB_CRI_CRIME_FKIndex3(TAU_IDTIPO_ARMA_USADA),
  INDEX TB_CRI_CRIME_FKIndex4(TTR_IDTIPO_TRANSPORTE),
  INDEX TB_CRI_CRIME_FKIndex5(TPA_IDTIPO_PAPEL),
  INDEX TB_CRI_CRIME_FKIndex6(TCR_IDTIPO_CRIME),
  INDEX TB_CRI_CRIME_FKIndex7(TLO_IDTIPO_LOCAL)
);

CREATE TABLE TB_CON_CONFIRMACAO (
  CON_IDCONFIRMACAO BIGINT NOT NULL AUTO_INCREMENT,
  CRI_IDCRIME BIGINT NOT NULL,
  CON_COMENTARIO TEXT NULL,
  CON_CONFIRMA INT(1) NULL,
  CON_EMAIL VARCHAR(255) NOT NULL,
  CON_NOME VARCHAR(255) NULL,
  CON_DATA_CONFIRMACAO DATE NULL,
  CON_DATA_ENVIO DATE NOT NULL,
  CON_CHAVE_CONFIRMACAO VARCHAR(255) NULL,
  PRIMARY KEY(CON_IDCONFIRMACAO),
  INDEX TB_CON_CONFIMACAO_FKIndex1(CRI_IDCRIME)
);

CREATE TABLE  `wikicrimes`.`tb_eme_email_enviado` (
  `eme_idemail_enviado` int(10) unsigned NOT NULL auto_increment,
  `cts_idcontrole_schedule` int(10) unsigned NOT NULL,
  `usu_idusuario` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`eme_idemail_enviado`)
);

CREATE TABLE  `wikicrimes`.`tb_cts_controle_schedule` (
  `cts_idcontrole_schedule` int(10) unsigned NOT NULL auto_increment,
  `pri_idperiodo_informacao` int(10) unsigned NOT NULL,
  `enviado` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`cts_idcontrole_schedule`)
);

-- Script para a inclus�o de dados necess�rios para o controle do schedule
INSERT INTO tb_cts_controle_schedule(cts_idcontrole_schedule, pri_idperiodo_informacao, enviado)
VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1);

-- Script para inclus�o dos periodos
INSERT INTO tb_pri_periodo_informacao VALUES
(1, 'webapp.area.label.mensalmente', 'mensalmente'),
(2, 'webapp.area.label.diariamente', 'diariamente'),
(3, 'webapp.area.label.semanalmente', 'semanalmente');

-- Script para a inclus�o dos subtipos de viol�ncias

insert into tb_tcv_crime_vitima values(5,6),(5,7), (5,8);
insert into tb_tvi_tipo_vitima values(6,'Homic�dio',''),(7,'Tentantiva de Homic�dio',''), (8,'Latroc�nio','');

-- Script para a inclus�o dos subtipos de viol�ncias

-- Script de perfil certificador 
insert into tb_per_perfil values(4,'CERTIFICADOR',null);
-- Script de perfil certificador

-- Script de entidades certificadoras
insert into tb_entcer_entidade_certificadora  (ENTCER_IDENTIDADECERTIFICADORA,entcer_nome,entcer_descricao) values(1,'Diario Nordeste','Equipe Diario do Nordeste');

--Script atualiza��o de idiomas
UPDATE TB_USU_USUARIO SET USU_IDIOMA = 'pt' WHERE USU_IDIOMA IS NULL AND (USU_PAIS LIKE 'BR' OR USU_PAIS LIKE 'PT');
UPDATE TB_USU_USUARIO SET USU_IDIOMA = 'es' WHERE USU_IDIOMA IS NULL AND (USU_PAIS LIKE 'ES' OR USU_PAIS LIKE 'MX' OR USU_PAIS LIKE 'AR');
UPDATE TB_USU_USUARIO SET USU_IDIOMA = 'en' WHERE USU_IDIOMA IS NULL

CREATE TABLE TB_L_LOG (
  L_IDLOG BIGINT NOT NULL AUTO_INCREMENT,
  L_CAMPO VARCHAR(30) NULL,
  L_CAMPO_NOVO TEXT NULL,
  L_CAMPO_ANTIGO TEXT NULL,
  L_DATA DATE NOT NULL,
  USU_IDUSUARIO BIGINT NOT NULL,
  L_IDOBJ BIGINT NOT NULL,
  TLOG_IDTIPO_LOG BIGINT NOT NULL,
  PRIMARY KEY(L_IDLOG),
  INDEX TB_L_LOG_FKIndex1(USU_IDUSUARIO),
  INDEX TB_L_LOG_FKIndex2(TLOG_IDTIPO_LOG),
  INDEX TB_L_LOG_FKIndex3(L_IDOBJ)
);

CREATE TABLE TB_TLOG_TIPO_LOG (
  TLOG_IDTIPO_LOG BIGINT NOT NULL AUTO_INCREMENT,
  TLOG_NOME VARCHAR(255) NULL,
  TLOG_DESCRICAO TEXT NULL,
  PRIMARY KEY(TLOG_IDTIPO_LOG)
);

INSERT INTO TB_TLOG_TIPO_LOG(TLOG_IDTIPO_LOG, TLOG_NOME, TLOG_DESCRICAO)  
VALUES  
(1, "Crime", ""),  
(2, "Usu�rio", "");

INSERT INTO `tb_raz_razao` (`RAZ_IDRAZAO`,`RAZ_NOME`,`RAZ_DESCRICAO`) VALUES
 (1,'razao.ma.iluminacao','M� ilumina��o p�blica'),
 (2,'razao.falta.lazer.jovens','Aus�ncia de lazer para os jovens'),
 (3,'razao.desemprego','Desemprego na regi�o'),
 (4,'razao.facil.acesso.fuga','F�cil acesso/fuga do criminoso'),
 (5,'razao.disputas.gangues','Disputa de gangues'),
 (6,'razao.trafico','Uso/Tr�fico de drogas'),
 (7,'razao.alcool.excesso','Uso de alcool'),
 (8,'razao.criancas.ruas','Crian�as/Adolescentes nas ruas'),
 (9,'razao.alta.cons.pessoas','Alta concentra��o de pessoas'),
 (10,'razao.falta.policiamento','Falta de Policiamento'),
 (11,'razao.omissao.testemunha','Omiss�o das testemunhas'), (12,'razao.regiao.perigosa','Proximidade de regioes perigosas'), (13,'razao.impunidade.penal','Impunidade Penal'), (14,'razao.pistolagem','Pistolagem'), (15,'razao.violencia.policial','Violencia Policial'),
(16,'razao.falta.moradia','Falta de Moradia/M� urbaniza��o'),
(17,'razao.crime.organizado','Crime organizado'),
(18,'razao.crime.passional','Crime passional'),
(19,'razao.outros','Outros'),
(20,'razao.naosei','N�o sei')
(21,'razao.vinganca','Vingan�a');

//atualizar relatos
UPDATE TB_REL_RELATO REL SET CRI_QTD_POS = 
(SELECT COUNT(*) FROM TB_CNR_CONFIRMACAO CNR 
		WHERE CNR.CNR_CONFIRMA = 1 
		AND CNR.REL_IDRELATO = REL.REL_IDRELATO )
			, CRI_QTD_NEG = 
(SELECT COUNT(*) FROM TB_CNR_CONFIRMACAO CNR 
		WHERE CNR.CNR_CONFIRMA = 0 
		AND CNR.REL_IDRELATO = REL.REL_IDRELATO )
//atualizar confirmacoes de crimes
UPDATE TB_cri_crime CRI SET CRI_CONFIRMACOES_POSITIVAS = 
(SELECT COUNT(*) FROM TB_CON_CONFIRMACAO CNR 
		WHERE CNR.CON_CONFIRMA = 1 
		AND CNR.CRI_IDCRIME = CRI.CRI_IDCRIME )
			, CRI_CONFIRMACOES_NEGATIVAS = 
(SELECT COUNT(*) FROM TB_CON_CONFIRMACAO CNR 
		WHERE CNR.CON_CONFIRMA = 0 
		AND CNR.CRI_IDCRIME = CRI.CRI_IDCRIME )

//atualizar qtd comentarios de crimes		
UPDATE TB_CRI_CRIME C SET C.CRI_QTD_COMENTARIOS =
(SELECT COUNT(*) FROM TB_CON_COMENTARIO CNR
		WHERE CNR.CRI_IDCRIME = C.CRI_IDCRIME )

//verificar inconsistencias
SELECT  t.cri_idcrime,count(*)  as quantidade, c.cri_confirmacoes_NEGATIVAS FROM tb_con_confirmacao t, tb_cri_crime c  where t.con_confirma=0 and t.cri_idcrime=c.cri_idcrime  group by t.cri_idcrime 


--seleciona todos os usu�rios que ser registraram ap�s uma indica��o.
select * from tb_usu_usuario u where usu_data_hora_registro > (SELECT c.cri_data_hora_registro FROM tb_con_confirmacao t, tb_cri_crime c where c.cri_idcrime = t.cri_idcrime and t.usu_idusuario = u.usu_idusuario LIMIT 0,1)


insert into tb_tve_tipo_violencia_escola_relato values(1,'tipo.violencia.relato.bullying', 'Bullying'),
						(2, 'tipo.violencia.relato.assedio.sexual', 'Ass�dio Sexual'),
						(3, 'tipo.violencia.relato.violencia.sexual', 'Viol�ncia Sexual'),
						(4, 'tipo.violencia.relato.roubo', 'Roubo')

insert into tb_tar_tipo_agressor_relato values (1,'tipo.agressor.relato.autor.unico.connhecido', 'Autor �nico e conhecido'),
					(2,'tipo.agressor.relato.autor.unico.desconnhecido', 'Autor �nico e desconhecido'),
					(3,'tipo.agressor.relato.gangue.conhecida', 'Gangue Conhecida'),
					(4,'tipo.agressor.relato.gangue.desconhecida', 'Gangue Desconhecida')
					
					
insert into tb_trr_tipo_report_relato values(1, 'tipo.report.relato.escola', 'Informou a Escola'),
										(2,'tipo.report.relato.pais', 'Informou aos Pais'),
										(3,'tipo.report.relato.escola.e.pais', 'Informou a Escola e aos Pais'),
										(4,'tipo.report.relato.medico', 'Informou ao M�dico'),
										(5,'tipo.report.relato.policia', 'Informou a Pol�cia'),
										(6,'tipo.report.relato.medico.e.policia', 'Informou ao M�dico e a Pol�cia'),
										(7,'tipo.report.relato.pais.e.medico', 'Informou aos Pais e ao M�dico'),
										(8,'tipo.report.relato.pais.medico.policia', 'Informou aos Pais, ao M�dico e a Pol�cial'),
										(9,'tipo.report.relato.ninguem',  'N�o Informou a Niguem')
										
insert into tb_tcr_tipo_consequencia_relato values(1,'tipo.consequencia.relato.sem.lesao', 'N�o houve les�o ou amea�a de roubo'),
											(2,'tipo.consequencia.relato.ameaca.roubo', 'Houve amea�a pessoal e roubo'),
											(3,'tipo.consequencia.relato.lesao.roubo', 'Houve les�o corporal e roubos'),
											(4,'tipo.consequencia.relato.ameaca.lesao.roubo', 'Amea�a pessoal com les�o corporal e roubo')

insert into tb_tlr_tipo_localizacao_relato values(1, 'tipo.localizacao.relato.escola', 'No pr�dio escolar'),
												(2, 'tipo.localizacao.relato.arredores.escola', 'Nos arredores da escola'),
												(3, 'tipo.localizacao.relato.banheiros.escola', 'Nos banheiros da escola'),
												(4, 'tipo.localizacao.relato.caminho.escola', 'A caminho da escola'),
												(5, 'tipo.localizacao.relato.voltando.escola', 'Voltado da escola')

insert into tb_tar_tipo_agressor_relato values(5,'tipo.agressor.relato.professor','Professor'),
					      (6,'tipo.agressor.relato.estudante','Estudante'),
					      (7,'tipo.agressor.relato.desconhecido','Desconhecido')
					    
insert into tb_trr_tipo_report_relato values(10,'tipo.report.relato.escola.medico','Informou a Escola e ao M�dico'),
					    (11,'tipo.report.relato.escola.medico.policia','Informou a Escola, ao Medico e a Policia')

insert into tb_tbr_tipo_bem_roubado_relato values(1,'tipo.bem.roubado.celular','Celular'),
						 (2,'tipo.bem.roubado.mp3','Mp3'),
						 (3,'tipo.bem.roubado.outro.aparelho','Outro Equipamento'),
						 (4,'tipo.bem.roubado.dinheiro','Dinheiro'),
						 (5,'tipo.bem.roubado.comida','Comida')		
						 
						 
update tb_usu_usuario set usu_email = concat(usu_idusuario,'@wikicrimes.org'),
			  usu_primeiro_nome = concat(usu_idusuario,'nome'),
			  usu_ultimo_nome = concat(usu_idusuario,'ultimo_nome'),
			  usu_senha = 'guest';
			  
insert into tb_tlo_tipo_local values(17,2,'tipolocalpropriedade.carga','carga');

INSERT INTO TB_TCV_CRIME_VITIMA(TCR_IDTIPO_CRIME, TVI_IDTIPO_VITIMA)
VALUES  
(5, 9);

INSERT INTO TB_TVI_TIPO_VITIMA (TVI_IDTIPO_VITIMA, TVI_NOME, TVI_DESCRICAO)
VALUES 
(9, 'tipovitima.atentadoaopudor', 'Atentado ao Pudor');
