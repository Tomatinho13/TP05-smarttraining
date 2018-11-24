--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.19
-- Dumped by pg_dump version 9.4.19
-- Started on 2018-11-24 21:51:36

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 18722)
-- Name: Aluno; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Aluno" (
    cod_cpf character varying(11) NOT NULL
);


ALTER TABLE public."Aluno" OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 18725)
-- Name: Aparelho; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Aparelho" (
    nro_aparelho integer NOT NULL,
    nom_aparelho character varying NOT NULL
);


ALTER TABLE public."Aparelho" OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 18731)
-- Name: AparelhoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."AparelhoExercicio" (
    cod_exercicio integer NOT NULL,
    nro_aparelho integer NOT NULL,
    img_execucao character varying NOT NULL
);


ALTER TABLE public."AparelhoExercicio" OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 18737)
-- Name: Avaliacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Avaliacao" (
    cod_cpf character varying(11) NOT NULL,
    dat_avaliacao date NOT NULL,
    cod_cpf_instrutor character varying(11) NOT NULL,
    qtd_peso numeric(5,2) NOT NULL,
    "qtd_massaGorda" numeric(5,2) NOT NULL,
    "qtd_percGordura" numeric(5,2) NOT NULL,
    tam_pescoco numeric(6,2) NOT NULL,
    tam_ombro numeric(6,2) NOT NULL,
    tam_torax numeric(6,2) NOT NULL,
    tam_abdomen numeric(6,2) NOT NULL,
    tam_cintura numeric(6,2) NOT NULL,
    tam_quadril numeric(6,2) NOT NULL,
    "tam_bracoEsq" numeric(6,2) NOT NULL,
    "tam_bracoDir" numeric(6,2) NOT NULL,
    "tam_antebracoEsq" numeric(6,2) NOT NULL,
    "tam_antebracoDir" numeric(6,2) NOT NULL,
    "tam_coxaEsq" numeric(6,2) NOT NULL,
    "tam_coxaDir" numeric(6,2) NOT NULL,
    "tam_panturrilhaEsq" numeric(6,2) NOT NULL,
    "tam_panturrilhaDir" numeric(6,2) NOT NULL
);


ALTER TABLE public."Avaliacao" OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 18740)
-- Name: DiaTreino; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."DiaTreino" (
    cod_exercicio integer NOT NULL,
    nro_aparelho integer NOT NULL,
    cod_cpf character varying(11) NOT NULL,
    nro_treino integer NOT NULL,
    nro_ficha integer NOT NULL,
    dat_treino date NOT NULL
);


ALTER TABLE public."DiaTreino" OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 18743)
-- Name: Exercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Exercicio" (
    cod_exercicio integer NOT NULL,
    nom_exercicio character varying NOT NULL,
    des_exercicio character varying NOT NULL
);


ALTER TABLE public."Exercicio" OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 18749)
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Exercicio_cod_exercicio_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Exercicio_cod_exercicio_seq" OWNER TO postgres;

--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 179
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Exercicio_cod_exercicio_seq" OWNED BY public."Exercicio".cod_exercicio;


--
-- TOC entry 180 (class 1259 OID 18751)
-- Name: Ficha; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Ficha" (
    cod_cpf character varying(11) NOT NULL,
    nro_ficha integer NOT NULL,
    cod_cpf_instrutor character varying(11) NOT NULL,
    dat_ficha date NOT NULL,
    dat_prevista_troca date NOT NULL
);


ALTER TABLE public."Ficha" OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 18754)
-- Name: Instrutor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Instrutor" (
    cod_cpf character varying(11) NOT NULL,
    nro_cref character varying(11) NOT NULL
);


ALTER TABLE public."Instrutor" OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 18757)
-- Name: Musculo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Musculo" (
    cod_musculo integer NOT NULL,
    cod_regcorp integer,
    nom_musculo character varying NOT NULL,
    img_musculo integer NOT NULL
);


ALTER TABLE public."Musculo" OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 18763)
-- Name: MusculoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."MusculoExercicio" (
    cod_exercicio integer NOT NULL,
    cod_musculo integer NOT NULL
);


ALTER TABLE public."MusculoExercicio" OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 18766)
-- Name: Objetivo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Objetivo" (
    cod_objetivo integer NOT NULL,
    nom_objetivo character varying NOT NULL,
    des_objetivo character varying NOT NULL
);


ALTER TABLE public."Objetivo" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 18772)
-- Name: ObjetivoAvaliacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."ObjetivoAvaliacao" (
    dat_avaliacao date NOT NULL,
    cod_cpf character varying(11) NOT NULL,
    cod_objetivo integer NOT NULL
);


ALTER TABLE public."ObjetivoAvaliacao" OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 18775)
-- Name: RegiaoCorporal; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."RegiaoCorporal" (
    cod_regcorp integer NOT NULL,
    nom_regcorp character varying NOT NULL
);


ALTER TABLE public."RegiaoCorporal" OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 18781)
-- Name: Treino; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Treino" (
    cod_cpf character varying(11) NOT NULL,
    nro_ficha integer NOT NULL,
    nro_treino integer NOT NULL,
    des_treino character varying NOT NULL
);


ALTER TABLE public."Treino" OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 18787)
-- Name: TreinoExercicio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."TreinoExercicio" (
    cod_cpf character varying(11) NOT NULL,
    nro_treino integer NOT NULL,
    cod_exercicio integer NOT NULL,
    nro_aparelho integer NOT NULL,
    nro_ficha integer NOT NULL,
    nro_series integer NOT NULL,
    nro_repeticoes character varying(6) NOT NULL,
    qtd_peso integer NOT NULL
);


ALTER TABLE public."TreinoExercicio" OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 18790)
-- Name: Usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public."Usuario" (
    cod_cpf character varying(11) NOT NULL,
    nom_usuario character varying NOT NULL,
    idt_tipo_usuario character varying(1) NOT NULL,
    txt_senha character varying NOT NULL,
    des_email character varying NOT NULL,
    dat_nascimento date NOT NULL
);


ALTER TABLE public."Usuario" OWNER TO postgres;

--
-- TOC entry 1949 (class 2604 OID 18796)
-- Name: cod_exercicio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Exercicio" ALTER COLUMN cod_exercicio SET DEFAULT nextval('public."Exercicio_cod_exercicio_seq"'::regclass);


--
-- TOC entry 2111 (class 0 OID 18722)
-- Dependencies: 173
-- Data for Name: Aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Aluno" (cod_cpf) FROM stdin;
00000000000
11111111111
22222222222
33333333333
44444444444
55555555555
66666666666
77777777777
69696969696
88888888888
99999999999
10101010101
12121212121
09876543210
98999999999
21231231231
31231231111
42421412125
54358295382
95821059804
49823940804
23123901293
04812094812
98129034812
41982409218
49874891748
39081239081
94892108401
24242424242
42038192318
49128409210
17171717171
32910380123
49872481092
\.


--
-- TOC entry 2112 (class 0 OID 18725)
-- Dependencies: 174
-- Data for Name: Aparelho; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Aparelho" (nro_aparelho, nom_aparelho) FROM stdin;
30	Barra paralela
1	Bicicleta Horizontal
2	Bicicleta Vertical
3	Eliptico
4	Esteira
5	Supino Reto
6	Supino Inclinado
7	Supino Declinado
9	Remada a Frente
10	Desenvolvimento Articulado
11	Hack Machine
12	Pulley
13	Crossover
14	Banco Scott
15	Banco Reclinavel
16	Colchonete
18	Supino Articulado
19	Leg Press Horizontal
20	Leg Press 45º
21	Leg Press Vertical
22	Mesa Flexora
8	Cadeira Flexora
17	Cadeira Extensora
23	Cadeira Adutora
24	Cadeira Abdutora
25	Banco Soleo
26	Voador Dorsal
27	Barra Fixa
28	Remada Baixa
29	Graviton
\.


--
-- TOC entry 2113 (class 0 OID 18731)
-- Dependencies: 175
-- Data for Name: AparelhoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."AparelhoExercicio" (cod_exercicio, nro_aparelho, img_execucao) FROM stdin;
54	9	
54	28	
55	30	
55	29	
1	1	
1	2	
1	3	
1	4	
2	5	
3	6	
4	7	
6	10	
7	11	
8	12	
9	12	
10	12	
11	12	
12	13	
13	13	
14	13	
15	13	
16	14	
17	14	
18	15	
19	15	
20	15	
33	15	
34	15	
35	15	
37	16	
38	16	
39	16	
40	16	
41	18	
42	19	
42	20	
42	21	
43	19	
43	20	
43	21	
44	22	
44	8	
45	17	
46	23	
47	24	
48	25	
49	26	
50	26	
51	27	
52	27	
\.


--
-- TOC entry 2114 (class 0 OID 18737)
-- Dependencies: 176
-- Data for Name: Avaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Avaliacao" (cod_cpf, dat_avaliacao, cod_cpf_instrutor, qtd_peso, "qtd_massaGorda", "qtd_percGordura", tam_pescoco, tam_ombro, tam_torax, tam_abdomen, tam_cintura, tam_quadril, "tam_bracoEsq", "tam_bracoDir", "tam_antebracoEsq", "tam_antebracoDir", "tam_coxaEsq", "tam_coxaDir", "tam_panturrilhaEsq", "tam_panturrilhaDir") FROM stdin;
11111111111	2018-11-24	12345678901	70.00	10.00	15.00	10.00	50.00	100.00	60.00	80.00	100.00	30.00	30.00	20.00	20.00	60.00	60.00	30.00	30.00
11111111111	2019-02-24	12345678901	70.00	10.00	15.00	10.00	50.00	100.00	60.00	80.00	100.00	30.00	30.00	20.00	20.00	60.00	60.00	30.00	30.00
\.


--
-- TOC entry 2115 (class 0 OID 18740)
-- Dependencies: 177
-- Data for Name: DiaTreino; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."DiaTreino" (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha, dat_treino) FROM stdin;
\.


--
-- TOC entry 2116 (class 0 OID 18743)
-- Dependencies: 178
-- Data for Name: Exercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Exercicio" (cod_exercicio, nom_exercicio, des_exercicio) FROM stdin;
1	Aerobico	Treino aerobico
2	Supino Reto	Supino Reto com barra
3	Supino Inclinado	Supino inclinado com barra
4	Supino declinado	Supino declinado com barra
6	Desenvolvimento Articulado	Desenvolvimento articulado na máquina
7	Agachamento no Hack	Agachamento no Hack Machine
8	Pulley Costas	Pulley para treino das costas
9	Pulley Triangulo	Pulley com o triangulo
10	Pulley Frontal	Pulley com barra na frente
11	Pulley Supinado	Pulley com barra e pegada supinada
12	Biceps cross	Biceps com barra no crossover
13	Triceps Cross	Triceps com barra no crossover
14	Triceps Inverso Cross	Triceps com barra e pegada supinada no crossover
15	Crossover	Crossover (ou pulley cruzado) no proprio crossover
16	Rosca scott com halter	Rosca no banco scott com halter
17	Rosca Scott com barra W	Rosca no banco scott com barra w
18	Rosca de punho	Rosca de punho no banco
19	Rosca de punho invertido	Rosca de punho no banco com pegada invertida
20	Pullover com halter	Pullover no banco com halter
33	Supino reto com halter	Supino reto com halter no banco reclinavel
34	Triceps Martelo	Triceps martelo no banco reclinavel
35	Remada unilateral no banco	Remada unilateral no banco reclinavel com halter
37	Abdominal Russo	Abdominal russo com halter no colchonete
38	Abdominal Supra	Abdominal Supra no colchonete
39	Abdominal Infra	Abdominal infra no colchonete
40	Prancha ventral	Prancha ventral no colchonete
41	Supino articulado	Supino articulado na maquina
42	Leg aberto	Leg Press horizontal aberto
43	Leg fechado	Leg press fechado
44	Flexao de perna	Flexao de perna na maquina
45	Extensao de perna	Extensao de perna na maquina
46	Adutor	Adutor na maquina
47	Abdutor	Abdutor na maquina
48	Panturrilha Soleo	Panturrilha no banco soleo
49	Crucifixo	Crucifixo na maquina
50	Peitoral dorsal	Peitoral dorsal na maquina
51	Barra supinada	Barra supinada na barra fixa
52	Barra pronada	Barra pronada na barra fixa
54	Remada	Remada na maquina
55	Triceps na barra paralela	Barra paralela na maquina ou barra fixa
\.


--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 179
-- Name: Exercicio_cod_exercicio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Exercicio_cod_exercicio_seq"', 55, true);


--
-- TOC entry 2118 (class 0 OID 18751)
-- Dependencies: 180
-- Data for Name: Ficha; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Ficha" (cod_cpf, nro_ficha, cod_cpf_instrutor, dat_ficha, dat_prevista_troca) FROM stdin;
\.


--
-- TOC entry 2119 (class 0 OID 18754)
-- Dependencies: 181
-- Data for Name: Instrutor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Instrutor" (cod_cpf, nro_cref) FROM stdin;
23981209381	23981209381
19381209382	83667847583
12345678901	12345678901
39489012481	19239459697
40921840912	20378945612
39120381293	10923949999
12930182309	12345678912
00000000001	10923949991
\.


--
-- TOC entry 2120 (class 0 OID 18757)
-- Dependencies: 182
-- Data for Name: Musculo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Musculo" (cod_musculo, cod_regcorp, nom_musculo, img_musculo) FROM stdin;
1	1	Peitoral maior	1
3	2	Reto abdominal	1
5	3	Quadriceps	1
6	3	Biceps da coxa	1
7	3	Panturrilha	1
8	4	Biceps	1
9	4	Triceps	1
11	5	Trapezio	1
10	4	Antebraco	1
4	2	Obliquo	1
\.


--
-- TOC entry 2121 (class 0 OID 18763)
-- Dependencies: 183
-- Data for Name: MusculoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."MusculoExercicio" (cod_exercicio, cod_musculo) FROM stdin;
33	1
33	9
34	9
35	8
35	11
37	4
38	3
39	3
40	3
41	1
41	9
42	5
43	5
44	6
45	5
46	6
47	5
48	7
49	1
49	9
50	8
50	11
51	8
51	11
52	8
52	11
54	8
54	11
55	9
1	7
2	1
2	9
3	1
3	9
4	1
4	9
6	1
6	9
7	5
8	8
8	11
9	8
9	11
10	8
10	11
11	8
11	11
12	8
13	9
14	9
15	1
15	9
16	8
16	11
17	8
17	11
18	10
19	10
20	1
20	9
\.


--
-- TOC entry 2122 (class 0 OID 18766)
-- Dependencies: 184
-- Data for Name: Objetivo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Objetivo" (cod_objetivo, nom_objetivo, des_objetivo) FROM stdin;
1	Hipertrofia	Ganho de massa muscular
2	Emagrecimento	Perda de massa gorda
\.


--
-- TOC entry 2123 (class 0 OID 18772)
-- Dependencies: 185
-- Data for Name: ObjetivoAvaliacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."ObjetivoAvaliacao" (dat_avaliacao, cod_cpf, cod_objetivo) FROM stdin;
2018-11-24	11111111111	1
2018-11-24	11111111111	2
\.


--
-- TOC entry 2124 (class 0 OID 18775)
-- Dependencies: 186
-- Data for Name: RegiaoCorporal; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."RegiaoCorporal" (cod_regcorp, nom_regcorp) FROM stdin;
1	Peito
2	Abdome
3	Perna
4	Braço
5	Costas
\.


--
-- TOC entry 2125 (class 0 OID 18781)
-- Dependencies: 187
-- Data for Name: Treino; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Treino" (cod_cpf, nro_ficha, nro_treino, des_treino) FROM stdin;
\.


--
-- TOC entry 2126 (class 0 OID 18787)
-- Dependencies: 188
-- Data for Name: TreinoExercicio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."TreinoExercicio" (cod_cpf, nro_treino, cod_exercicio, nro_aparelho, nro_ficha, nro_series, nro_repeticoes, qtd_peso) FROM stdin;
\.


--
-- TOC entry 2127 (class 0 OID 18790)
-- Dependencies: 189
-- Data for Name: Usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Usuario" (cod_cpf, nom_usuario, idt_tipo_usuario, txt_senha, des_email, dat_nascimento) FROM stdin;
01987654321	Gilmar	C	123	gilmar@kosmos.com	1808-04-20
11111111111	Felipe de Paula	A	123	pipo@gmail.com	2000-08-29
22222222222	Augusto Carvalho	A	123	augusto@gmail.com	1995-04-28
00000000000	Gabriel de Araujo	A	123	gabriel44558888@gmail.com	2001-04-25
33333333333	Matheus Quintao Santiago	A	123	quintao@gmail.com	1990-12-03
44444444444	Joao Victor Melo	A	123	melogalo13@gmail.com	2003-02-03
55555555555	Aline Cristina	A	123	aline@gmail.com	2001-01-01
66666666666	Allan Barbosa	A	123	barb@gmail.com	1982-08-18
77777777777	Arthur Yochio	A	123	lilraff@gmail.com	1964-04-01
69696969696	Alice Codama	A	123	alicinha@codama.com	1989-05-16
88888888888	Carlos Brasileiro	A	123	carlos@gmail.com	1961-11-14
99999999999	Douglas Salustiano	A	123	douglas@gmail.com	1985-10-02
10101010101	Eduardo Cotta	A	123	cotta@gmail.com	1972-11-22
12121212121	Emanuela Amorim	A	123	manu@gmail.com	2000-04-04
09876543210	Eduardo Epiphanio	A	123	epiphanio@reddead2.com	1974-11-06
98999999999	Brian Bueno	A	123	bryann@gmail.com	2004-04-01
21231231231	Joice Sena	A	123	joice@gmail.com	2002-06-16
31231231111	Nicolas Catarina	A	123	nicolas@gmail.com	1998-02-12
42421412125	Gabriel  Torres	A	123	batata@pao.com	1999-06-23
54358295382	Leonardo Gomide	A	123	leo@gmail.com	1992-12-23
95821059804	Pedro Lucas	A	123	pedrolucas@gmail.com	1976-07-02
49823940804	Heitor de Pinho	A	123	heitor@gmail.com	2002-09-02
23123901293	Ruan Bertuce	A	123	paje@gmail.com	1994-01-01
04812094812	Hiago de Castro	A	123	hiago@gmail.com	1990-09-30
98129034812	Luiz Gustavo	A	123	luig@gmail.com	2001-07-03
41982409218	Joao Victor Bonfim	A	123	bonfim@gmail.com	1974-12-01
49874891748	Joao Pedro Santana	A	123	jpsantana@gmail.com	1980-03-01
39081239081	Andre Lousin	A	123	lolzim@gmail.com	1993-08-26
94892108401	Igor Titan	A	123	titan44@gmail.com	1986-12-23
24242424242	Gabriel Vinicius	A	123	gbzim@gmail.com	1930-06-18
42038192318	Matheus Morato	A	123	morato@gmail.com	1950-01-02
49128409210	Juliana Carvalho	A	123	juliana@gmail.com	2000-08-24
17171717171	Pedro Henrique Vieira	A	123	mito17@gmail.com	1989-07-25
32910380123	Sammuel Reis	A	123	sammy@gmail.com	1992-03-29
49872481092	Livia Delgado	A	123	livia@gmail.com	1996-03-09
23981209381	Francisco Pazzini	I	123	pazzini@gmail.com	1979-07-30
19381209382	Cristiano Maffort	I	123	maffort@gmail.com	1982-08-17
12345678901	Elson Maromba	I	123	elson@gmail.com	1990-02-02
39489012481	Flavio Coutinho	I	123	coutinho@gmail.com	1985-08-29
40921840912	Glivia Angelica	I	123	glivia@gmail.com	1982-10-09
39120381293	Mano Pantuza	I	123	pantuza@gmail.com	1975-06-19
12930182309	Jose Wilson	I	123	taerrado@gmail.com	1912-01-01
00000000001	Gilmar	I	123	gilmar@gmail.com	0001-01-01
\.


--
-- TOC entry 1980 (class 2606 OID 18798)
-- Name: Key14; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Treino"
    ADD CONSTRAINT "Key14" PRIMARY KEY (cod_cpf, nro_treino, nro_ficha);


--
-- TOC entry 1970 (class 2606 OID 18800)
-- Name: Key16; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Musculo"
    ADD CONSTRAINT "Key16" PRIMARY KEY (cod_musculo);


--
-- TOC entry 1978 (class 2606 OID 18802)
-- Name: Key17; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."RegiaoCorporal"
    ADD CONSTRAINT "Key17" PRIMARY KEY (cod_regcorp);


--
-- TOC entry 1972 (class 2606 OID 18804)
-- Name: Key18; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."MusculoExercicio"
    ADD CONSTRAINT "Key18" PRIMARY KEY (cod_exercicio, cod_musculo);


--
-- TOC entry 1953 (class 2606 OID 18806)
-- Name: Key19; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Aparelho"
    ADD CONSTRAINT "Key19" PRIMARY KEY (nro_aparelho);


--
-- TOC entry 1951 (class 2606 OID 18808)
-- Name: Key2; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Aluno"
    ADD CONSTRAINT "Key2" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1955 (class 2606 OID 18810)
-- Name: Key20; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."AparelhoExercicio"
    ADD CONSTRAINT "Key20" PRIMARY KEY (cod_exercicio, nro_aparelho);


--
-- TOC entry 1982 (class 2606 OID 18812)
-- Name: Key21; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."TreinoExercicio"
    ADD CONSTRAINT "Key21" PRIMARY KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha);


--
-- TOC entry 1974 (class 2606 OID 18814)
-- Name: Key22; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Objetivo"
    ADD CONSTRAINT "Key22" PRIMARY KEY (cod_objetivo);


--
-- TOC entry 1976 (class 2606 OID 18816)
-- Name: Key23; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."ObjetivoAvaliacao"
    ADD CONSTRAINT "Key23" PRIMARY KEY (cod_objetivo, cod_cpf, dat_avaliacao);


--
-- TOC entry 1960 (class 2606 OID 18818)
-- Name: Key24; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."DiaTreino"
    ADD CONSTRAINT "Key24" PRIMARY KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, dat_treino, nro_ficha);


--
-- TOC entry 1967 (class 2606 OID 18820)
-- Name: Key3; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Instrutor"
    ADD CONSTRAINT "Key3" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1984 (class 2606 OID 18822)
-- Name: Key5; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Key5" PRIMARY KEY (cod_cpf);


--
-- TOC entry 1962 (class 2606 OID 18824)
-- Name: Key6; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Exercicio"
    ADD CONSTRAINT "Key6" PRIMARY KEY (cod_exercicio);


--
-- TOC entry 1965 (class 2606 OID 18826)
-- Name: Key7; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Ficha"
    ADD CONSTRAINT "Key7" PRIMARY KEY (cod_cpf, nro_ficha);


--
-- TOC entry 1958 (class 2606 OID 18828)
-- Name: Key8; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public."Avaliacao"
    ADD CONSTRAINT "Key8" PRIMARY KEY (cod_cpf, dat_avaliacao);


--
-- TOC entry 1963 (class 1259 OID 18829)
-- Name: IX_Relationship11; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship11" ON public."Ficha" USING btree (cod_cpf_instrutor);


--
-- TOC entry 1956 (class 1259 OID 18830)
-- Name: IX_Relationship13; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship13" ON public."Avaliacao" USING btree (cod_cpf_instrutor);


--
-- TOC entry 1968 (class 1259 OID 18831)
-- Name: IX_Relationship20; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "IX_Relationship20" ON public."Musculo" USING btree (cod_regcorp);


--
-- TOC entry 1991 (class 2606 OID 18832)
-- Name: Relationship11; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ficha"
    ADD CONSTRAINT "Relationship11" FOREIGN KEY (cod_cpf_instrutor) REFERENCES public."Instrutor"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1988 (class 2606 OID 18837)
-- Name: Relationship12; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Avaliacao"
    ADD CONSTRAINT "Relationship12" FOREIGN KEY (cod_cpf) REFERENCES public."Aluno"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1989 (class 2606 OID 18842)
-- Name: Relationship13; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Avaliacao"
    ADD CONSTRAINT "Relationship13" FOREIGN KEY (cod_cpf_instrutor) REFERENCES public."Instrutor"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1999 (class 2606 OID 18847)
-- Name: Relationship17; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Treino"
    ADD CONSTRAINT "Relationship17" FOREIGN KEY (cod_cpf, nro_ficha) REFERENCES public."Ficha"(cod_cpf, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1994 (class 2606 OID 18852)
-- Name: Relationship20; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Musculo"
    ADD CONSTRAINT "Relationship20" FOREIGN KEY (cod_regcorp) REFERENCES public."RegiaoCorporal"(cod_regcorp) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1995 (class 2606 OID 18857)
-- Name: Relationship21; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MusculoExercicio"
    ADD CONSTRAINT "Relationship21" FOREIGN KEY (cod_exercicio) REFERENCES public."Exercicio"(cod_exercicio) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1996 (class 2606 OID 18862)
-- Name: Relationship22; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."MusculoExercicio"
    ADD CONSTRAINT "Relationship22" FOREIGN KEY (cod_musculo) REFERENCES public."Musculo"(cod_musculo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1986 (class 2606 OID 18867)
-- Name: Relationship23; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."AparelhoExercicio"
    ADD CONSTRAINT "Relationship23" FOREIGN KEY (cod_exercicio) REFERENCES public."Exercicio"(cod_exercicio) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1987 (class 2606 OID 18872)
-- Name: Relationship24; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."AparelhoExercicio"
    ADD CONSTRAINT "Relationship24" FOREIGN KEY (nro_aparelho) REFERENCES public."Aparelho"(nro_aparelho) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2000 (class 2606 OID 18877)
-- Name: Relationship25; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TreinoExercicio"
    ADD CONSTRAINT "Relationship25" FOREIGN KEY (cod_exercicio, nro_aparelho) REFERENCES public."AparelhoExercicio"(cod_exercicio, nro_aparelho) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2001 (class 2606 OID 18882)
-- Name: Relationship26; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."TreinoExercicio"
    ADD CONSTRAINT "Relationship26" FOREIGN KEY (cod_cpf, nro_treino, nro_ficha) REFERENCES public."Treino"(cod_cpf, nro_treino, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1997 (class 2606 OID 18887)
-- Name: Relationship27; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ObjetivoAvaliacao"
    ADD CONSTRAINT "Relationship27" FOREIGN KEY (cod_objetivo) REFERENCES public."Objetivo"(cod_objetivo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1998 (class 2606 OID 18892)
-- Name: Relationship28; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ObjetivoAvaliacao"
    ADD CONSTRAINT "Relationship28" FOREIGN KEY (cod_cpf, dat_avaliacao) REFERENCES public."Avaliacao"(cod_cpf, dat_avaliacao) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1990 (class 2606 OID 18897)
-- Name: Relationship29; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."DiaTreino"
    ADD CONSTRAINT "Relationship29" FOREIGN KEY (cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha) REFERENCES public."TreinoExercicio"(cod_exercicio, nro_aparelho, cod_cpf, nro_treino, nro_ficha) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1985 (class 2606 OID 18902)
-- Name: Relationship6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Aluno"
    ADD CONSTRAINT "Relationship6" FOREIGN KEY (cod_cpf) REFERENCES public."Usuario"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1993 (class 2606 OID 18907)
-- Name: Relationship7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Instrutor"
    ADD CONSTRAINT "Relationship7" FOREIGN KEY (cod_cpf) REFERENCES public."Usuario"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1992 (class 2606 OID 18912)
-- Name: Relationship9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Ficha"
    ADD CONSTRAINT "Relationship9" FOREIGN KEY (cod_cpf) REFERENCES public."Aluno"(cod_cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 7
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-11-24 21:51:36

--
-- PostgreSQL database dump complete
--

