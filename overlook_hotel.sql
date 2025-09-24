--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: chambre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chambre (
    id integer NOT NULL,
    numero integer NOT NULL,
    prix numeric(10,2) NOT NULL,
    nb_personne integer NOT NULL,
    disponible boolean DEFAULT true
);


ALTER TABLE public.chambre OWNER TO postgres;

--
-- Name: chambre_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chambre_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.chambre_id_seq OWNER TO postgres;

--
-- Name: chambre_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.chambre_id_seq OWNED BY public.chambre.id;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    prenom character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    motdepasse character varying(255) NOT NULL,
    point_fidelite integer DEFAULT 0 NOT NULL,
    salt character varying(255),
    id_role integer DEFAULT 3
);


ALTER TABLE public.client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;


--
-- Name: employer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employer (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    prenom character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    motdepasse character varying(255) NOT NULL,
    salaire numeric(10,2) NOT NULL,
    poste character varying(100) NOT NULL,
    date_embauche date DEFAULT CURRENT_DATE,
    actif boolean DEFAULT true,
    salt character varying(255),
    id_role integer DEFAULT 2
);


ALTER TABLE public.employer OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.employer_id_seq OWNER TO postgres;

--
-- Name: employer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employer_id_seq OWNED BY public.employer.id;


--
-- Name: evaluation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evaluation (
    id integer NOT NULL,
    id_client integer NOT NULL,
    note integer,
    commentaire text,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT evaluation_note_check CHECK (((note >= 1) AND (note <= 5)))
);


ALTER TABLE public.evaluation OWNER TO postgres;

--
-- Name: evaluation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evaluation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.evaluation_id_seq OWNER TO postgres;

--
-- Name: evaluation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evaluation_id_seq OWNED BY public.evaluation.id;


--
-- Name: evenement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evenement (
    id integer NOT NULL,
    nom character varying(255) NOT NULL,
    date date NOT NULL,
    heure time without time zone NOT NULL,
    prix numeric(10,2) NOT NULL,
    place_dispo integer NOT NULL,
    nb_reserver integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.evenement OWNER TO postgres;

--
-- Name: evenement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.evenement_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.evenement_id_seq OWNER TO postgres;

--
-- Name: evenement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.evenement_id_seq OWNED BY public.evenement.id;


--
-- Name: notification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notification (
    id integer NOT NULL,
    id_client integer,
    id_evenement integer,
    id_employer integer,
    titre character varying(255) NOT NULL,
    description text,
    date timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    lu boolean DEFAULT false
);


ALTER TABLE public.notification OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.notification_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.notification_id_seq OWNER TO postgres;

--
-- Name: notification_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.notification_id_seq OWNED BY public.notification.id;


--
-- Name: rapport; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rapport (
    id integer NOT NULL,
    titre character varying(255) NOT NULL,
    description text,
    date_generation timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    genere_par integer
);


ALTER TABLE public.rapport OWNER TO postgres;

--
-- Name: rapport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rapport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rapport_id_seq OWNER TO postgres;

--
-- Name: rapport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rapport_id_seq OWNED BY public.rapport.id;


--
-- Name: reservation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservation (
    id integer NOT NULL,
    id_client integer NOT NULL,
    id_chambre integer NOT NULL,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    statut character varying(50) DEFAULT 'EN_ATTENTE'::character varying,
    date_creation timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.reservation OWNER TO postgres;

--
-- Name: reservation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.reservation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.reservation_id_seq OWNER TO postgres;

--
-- Name: reservation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;


--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id integer NOT NULL,
    nom character varying(50) NOT NULL
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.role_id_seq OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- Name: chambre id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre ALTER COLUMN id SET DEFAULT nextval('public.chambre_id_seq'::regclass);


--
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);


--
-- Name: employer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer ALTER COLUMN id SET DEFAULT nextval('public.employer_id_seq'::regclass);


--
-- Name: evaluation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation ALTER COLUMN id SET DEFAULT nextval('public.evaluation_id_seq'::regclass);


--
-- Name: evenement id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement ALTER COLUMN id SET DEFAULT nextval('public.evenement_id_seq'::regclass);


--
-- Name: notification id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification ALTER COLUMN id SET DEFAULT nextval('public.notification_id_seq'::regclass);


--
-- Name: rapport id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rapport ALTER COLUMN id SET DEFAULT nextval('public.rapport_id_seq'::regclass);


--
-- Name: reservation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation ALTER COLUMN id SET DEFAULT nextval('public.reservation_id_seq'::regclass);


--
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- Data for Name: chambre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chambre (id, numero, prix, nb_personne, disponible) FROM stdin;
1	100	55.00	1	t
2	110	60.00	1	t
3	120	60.00	2	t
4	200	80.00	4	t
\.


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.client (id, nom, prenom, mail, motdepasse, point_fidelite, salt, id_role) FROM stdin;
1	Lennon	Bob	pyrobarbare@gmail.com	12345	50	ITSSALT555	3
2	Emilio	Emile	emilEmilio@gmail.com	12345	20	ITSSALT555	3
3	Carel	Rebeka	Rebekarel@hotmail.fr	12345	10	ITSSALT555	3
\.


--
-- Data for Name: employer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employer (id, nom, prenom, mail, motdepasse, salaire, poste, date_embauche, actif, salt, id_role) FROM stdin;
1	Dupon	Dupont	Dupon.dupont@hotmail.fr	azerty	2500.00	Manager	2025-09-21	t	ITSverySALT555	1
2	Jean	Montcuq	montcuq.bestville@gmail.com	qwerty	1800.00	R‚ceptionniste	2025-09-21	t	ITSverySALT555	2
\.


--
-- Data for Name: evaluation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evaluation (id, id_client, note, commentaire, date) FROM stdin;
1	1	5	Super s‚jour, personnel trŠs accueillant !	2025-09-21 19:36:04.923359
2	2	4	Bonne exp‚rience, mais chambre un peu petite.	2025-09-21 19:36:04.923359
\.


--
-- Data for Name: evenement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evenement (id, nom, date, heure, prix, place_dispo, nb_reserver) FROM stdin;
1	Concert de No‰l	2025-12-24	18:00:00	15.00	50	0
2	Atelier poterie	2025-12-20	13:30:00	0.00	20	0
\.


--
-- Data for Name: notification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notification (id, id_client, id_evenement, id_employer, titre, description, date, lu) FROM stdin;
\.


--
-- Data for Name: rapport; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rapport (id, titre, description, date_generation, genere_par) FROM stdin;
\.


--
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservation (id, id_client, id_chambre, date_debut, date_fin, statut, date_creation) FROM stdin;
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, nom) FROM stdin;
1	ADMIN
2	EMPLOYEE
3	CLIENT
\.


--
-- Name: chambre_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.chambre_id_seq', 4, true);


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.client_id_seq', 3, true);


--
-- Name: employer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employer_id_seq', 2, true);


--
-- Name: evaluation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evaluation_id_seq', 2, true);


--
-- Name: evenement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evenement_id_seq', 2, true);


--
-- Name: notification_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.notification_id_seq', 1, false);


--
-- Name: rapport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rapport_id_seq', 1, false);


--
-- Name: reservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.reservation_id_seq', 1, false);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 3, true);


--
-- Name: chambre chambre_numero_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre
    ADD CONSTRAINT chambre_numero_key UNIQUE (numero);


--
-- Name: chambre chambre_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chambre
    ADD CONSTRAINT chambre_pkey PRIMARY KEY (id);


--
-- Name: client client_mail_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_mail_key UNIQUE (mail);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: employer employer_mail_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_mail_key UNIQUE (mail);


--
-- Name: employer employer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_pkey PRIMARY KEY (id);


--
-- Name: evaluation evaluation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation
    ADD CONSTRAINT evaluation_pkey PRIMARY KEY (id);


--
-- Name: evenement evenement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evenement
    ADD CONSTRAINT evenement_pkey PRIMARY KEY (id);


--
-- Name: notification notification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_pkey PRIMARY KEY (id);


--
-- Name: rapport rapport_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rapport
    ADD CONSTRAINT rapport_pkey PRIMARY KEY (id);


--
-- Name: reservation reservation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);


--
-- Name: role role_nom_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_nom_key UNIQUE (nom);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: client client_id_role_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_id_role_fkey FOREIGN KEY (id_role) REFERENCES public.role(id);


--
-- Name: employer employer_id_role_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employer
    ADD CONSTRAINT employer_id_role_fkey FOREIGN KEY (id_role) REFERENCES public.role(id);


--
-- Name: evaluation evaluation_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation
    ADD CONSTRAINT evaluation_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- Name: notification notification_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- Name: notification notification_id_employer_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_id_employer_fkey FOREIGN KEY (id_employer) REFERENCES public.employer(id);


--
-- Name: notification notification_id_evenement_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.notification
    ADD CONSTRAINT notification_id_evenement_fkey FOREIGN KEY (id_evenement) REFERENCES public.evenement(id);


--
-- Name: rapport rapport_genere_par_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rapport
    ADD CONSTRAINT rapport_genere_par_fkey FOREIGN KEY (genere_par) REFERENCES public.employer(id);


--
-- Name: reservation reservation_id_chambre_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_id_chambre_fkey FOREIGN KEY (id_chambre) REFERENCES public.chambre(id);


--
-- Name: reservation reservation_id_client_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_id_client_fkey FOREIGN KEY (id_client) REFERENCES public.client(id);


--
-- PostgreSQL database dump complete
--

