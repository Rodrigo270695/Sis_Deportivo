PGDMP     8                    z            bd_deportivo    15.0    15.0 d   
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    25565    bd_deportivo    DATABASE     ~   CREATE DATABASE bd_deportivo WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE bd_deportivo;
                postgres    false            �            1259    25566 
   alineacion    TABLE     �   CREATE TABLE public.alineacion (
    partido_id integer NOT NULL,
    equipo_id integer NOT NULL,
    futbolista_id integer NOT NULL,
    tipo_jugador_id integer NOT NULL,
    posicion_id smallint NOT NULL
);
    DROP TABLE public.alineacion;
       public         heap    postgres    false            �            1259    25569    arbitro    TABLE     �   CREATE TABLE public.arbitro (
    arbitro_id integer NOT NULL,
    arbitro_nombre character varying(50) NOT NULL,
    estado_arbitro character(1) NOT NULL,
    pais_id integer NOT NULL
);
    DROP TABLE public.arbitro;
       public         heap    postgres    false            �            1259    25572    arbitro_arbitro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.arbitro_arbitro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.arbitro_arbitro_id_seq;
       public          postgres    false    215                       0    0    arbitro_arbitro_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.arbitro_arbitro_id_seq OWNED BY public.arbitro.arbitro_id;
          public          postgres    false    216            �            1259    25573    categoria_arbitro    TABLE     �   CREATE TABLE public.categoria_arbitro (
    categoria_arbitro_id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    sigla character(3) NOT NULL,
    tipo_terna_arbitral_id integer NOT NULL
);
 %   DROP TABLE public.categoria_arbitro;
       public         heap    postgres    false            �            1259    25576 *   categoria_arbitro_categoria_arbitro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.categoria_arbitro_categoria_arbitro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.categoria_arbitro_categoria_arbitro_id_seq;
       public          postgres    false    217                       0    0 *   categoria_arbitro_categoria_arbitro_id_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.categoria_arbitro_categoria_arbitro_id_seq OWNED BY public.categoria_arbitro.categoria_arbitro_id;
          public          postgres    false    218            �            1259    25577    ciudad    TABLE     �   CREATE TABLE public.ciudad (
    ciudad_id integer NOT NULL,
    nombre_completo character varying(100) NOT NULL,
    pais_id integer NOT NULL
);
    DROP TABLE public.ciudad;
       public         heap    postgres    false            �            1259    25580    ciudad_ciudad_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ciudad_ciudad_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.ciudad_ciudad_id_seq;
       public          postgres    false    219                       0    0    ciudad_ciudad_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.ciudad_ciudad_id_seq OWNED BY public.ciudad.ciudad_id;
          public          postgres    false    220            �            1259    25581    competencia    TABLE     �   CREATE TABLE public.competencia (
    competencia_id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL,
    fixture_id integer NOT NULL
);
    DROP TABLE public.competencia;
       public         heap    postgres    false            �            1259    25584    competencia_competencia_id_seq    SEQUENCE     �   CREATE SEQUENCE public.competencia_competencia_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.competencia_competencia_id_seq;
       public          postgres    false    221                       0    0    competencia_competencia_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.competencia_competencia_id_seq OWNED BY public.competencia.competencia_id;
          public          postgres    false    222            �            1259    25585    confederacion_futbol    TABLE     A  CREATE TABLE public.confederacion_futbol (
    confederacion_id integer NOT NULL,
    nombre_oficial character varying(255) NOT NULL,
    acronimo character varying(20) NOT NULL,
    ubicacion character varying(255),
    sede character varying(255),
    fecha_fundacion date,
    numero_federaciones_afiliadas integer
);
 (   DROP TABLE public.confederacion_futbol;
       public         heap    postgres    false            �            1259    25590 )   confederacion_futbol_confederacion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.confederacion_futbol_confederacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public.confederacion_futbol_confederacion_id_seq;
       public          postgres    false    223                       0    0 )   confederacion_futbol_confederacion_id_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.confederacion_futbol_confederacion_id_seq OWNED BY public.confederacion_futbol.confederacion_id;
          public          postgres    false    224            �            1259    25591 
   continente    TABLE     �   CREATE TABLE public.continente (
    continente_id integer NOT NULL,
    nombre character varying(30) NOT NULL,
    abreviatura character(3) NOT NULL
);
    DROP TABLE public.continente;
       public         heap    postgres    false            �            1259    25594    continente_continente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.continente_continente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.continente_continente_id_seq;
       public          postgres    false    225                       0    0    continente_continente_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.continente_continente_id_seq OWNED BY public.continente.continente_id;
          public          postgres    false    226            �            1259    25595    contrato_futbol    TABLE     �   CREATE TABLE public.contrato_futbol (
    contrato_id integer NOT NULL,
    fecha_inicio date,
    fecha_fin date,
    remuneracion double precision NOT NULL,
    descripcion character varying(255),
    futbolista_id integer NOT NULL
);
 #   DROP TABLE public.contrato_futbol;
       public         heap    postgres    false            �            1259    25598    contrato_futbol_contrato_id_seq    SEQUENCE     �   CREATE SEQUENCE public.contrato_futbol_contrato_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.contrato_futbol_contrato_id_seq;
       public          postgres    false    227                       0    0    contrato_futbol_contrato_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.contrato_futbol_contrato_id_seq OWNED BY public.contrato_futbol.contrato_id;
          public          postgres    false    228            �            1259    25599    cuerpo_tecnico    TABLE     �   CREATE TABLE public.cuerpo_tecnico (
    cuerpo_tecnico_id integer NOT NULL,
    nombre character varying(100) NOT NULL,
    profesional_id integer,
    tipo_profesional_id integer
);
 "   DROP TABLE public.cuerpo_tecnico;
       public         heap    postgres    false            �            1259    25602 $   cuerpo_tecnico_cuerpo_tecnico_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cuerpo_tecnico_cuerpo_tecnico_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.cuerpo_tecnico_cuerpo_tecnico_id_seq;
       public          postgres    false    229                       0    0 $   cuerpo_tecnico_cuerpo_tecnico_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.cuerpo_tecnico_cuerpo_tecnico_id_seq OWNED BY public.cuerpo_tecnico.cuerpo_tecnico_id;
          public          postgres    false    230            �            1259    25603    detalle_arbitro_terna_arbitral    TABLE     �   CREATE TABLE public.detalle_arbitro_terna_arbitral (
    arbitro_id integer NOT NULL,
    terna_arbitral_id integer NOT NULL,
    categoria_arbitro_id integer NOT NULL
);
 2   DROP TABLE public.detalle_arbitro_terna_arbitral;
       public         heap    postgres    false            �            1259    25606    detalle_categoria_arbitro    TABLE     ~   CREATE TABLE public.detalle_categoria_arbitro (
    arbitro_id integer NOT NULL,
    categoria_arbitro_id integer NOT NULL
);
 -   DROP TABLE public.detalle_categoria_arbitro;
       public         heap    postgres    false            �            1259    25609    detalle_competencia_equipo    TABLE     x   CREATE TABLE public.detalle_competencia_equipo (
    competencia_id integer NOT NULL,
    equipo_id integer NOT NULL
);
 .   DROP TABLE public.detalle_competencia_equipo;
       public         heap    postgres    false            �            1259    25612    detalle_competencia_grupo    TABLE     v   CREATE TABLE public.detalle_competencia_grupo (
    grupo_id integer NOT NULL,
    competencia_id integer NOT NULL
);
 -   DROP TABLE public.detalle_competencia_grupo;
       public         heap    postgres    false            �            1259    25618    detalle_equipo    TABLE     �   CREATE TABLE public.detalle_equipo (
    equipo_id integer NOT NULL,
    futbolista_id integer NOT NULL,
    posicion_id smallint NOT NULL
);
 "   DROP TABLE public.detalle_equipo;
       public         heap    postgres    false            �            1259    25621    detalle_equipo_futbolista    TABLE     �   CREATE TABLE public.detalle_equipo_futbolista (
    equipo_id integer NOT NULL,
    futbolista_id integer NOT NULL,
    competencia_id integer NOT NULL
);
 -   DROP TABLE public.detalle_equipo_futbolista;
       public         heap    postgres    false            �            1259    25624    detalle_grupo    TABLE     �   CREATE TABLE public.detalle_grupo (
    grupo_id integer NOT NULL,
    equipo_id integer NOT NULL,
    pj integer,
    g integer,
    e integer,
    p integer,
    gf integer,
    gc integer,
    df integer,
    pts integer
);
 !   DROP TABLE public.detalle_grupo;
       public         heap    postgres    false            �            1259    25627     detalle_organizacion_competencia    TABLE     |   CREATE TABLE public.detalle_organizacion_competencia (
    pais_id integer NOT NULL,
    competencia_id integer NOT NULL
);
 4   DROP TABLE public.detalle_organizacion_competencia;
       public         heap    postgres    false            �            1259    25630    detalle_pais_futbolista    TABLE     r   CREATE TABLE public.detalle_pais_futbolista (
    futbolista_id integer NOT NULL,
    pais_id integer NOT NULL
);
 +   DROP TABLE public.detalle_pais_futbolista;
       public         heap    postgres    false            �            1259    25633    detalle_partido    TABLE     q  CREATE TABLE public.detalle_partido (
    partido_id integer NOT NULL,
    equipo_id integer NOT NULL,
    tipo character varying(5) NOT NULL,
    goles smallint,
    posesion_balon character varying(10),
    numero_faltas smallint,
    tarjetas_amarillas smallint,
    tarjetas_rojas smallint,
    tiros smallint,
    tiros_puerta smallint,
    fuera_de_lugar smallint,
    tiros_esquina smallint,
    pases_completados integer,
    cambios character varying(255),
    dato_curioso character varying(255),
    distancia_recorrida character varying(50),
    balones_recuperados integer,
    formacion_id smallint NOT NULL
);
 #   DROP TABLE public.detalle_partido;
       public         heap    postgres    false            �            1259    25638    detalle_posicion_futbolista    TABLE     {   CREATE TABLE public.detalle_posicion_futbolista (
    futbolista_id integer NOT NULL,
    posicion_id smallint NOT NULL
);
 /   DROP TABLE public.detalle_posicion_futbolista;
       public         heap    postgres    false            �            1259    25641    detalle_profesional    TABLE     {   CREATE TABLE public.detalle_profesional (
    profesional_id integer NOT NULL,
    tipo_profesional_id integer NOT NULL
);
 '   DROP TABLE public.detalle_profesional;
       public         heap    postgres    false            �            1259    25644    detalle_terna_arbitral    TABLE     �   CREATE TABLE public.detalle_terna_arbitral (
    terna_arbitral_id integer NOT NULL,
    tipo_terna_arbitral_id integer NOT NULL
);
 *   DROP TABLE public.detalle_terna_arbitral;
       public         heap    postgres    false            �            1259    25647    dimension_campo    TABLE     {   CREATE TABLE public.dimension_campo (
    dimension_id integer NOT NULL,
    descripcion character varying(50) NOT NULL
);
 #   DROP TABLE public.dimension_campo;
       public         heap    postgres    false            �            1259    25650     dimension_campo_dimension_id_seq    SEQUENCE     �   CREATE SEQUENCE public.dimension_campo_dimension_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.dimension_campo_dimension_id_seq;
       public          postgres    false    244                       0    0     dimension_campo_dimension_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.dimension_campo_dimension_id_seq OWNED BY public.dimension_campo.dimension_id;
          public          postgres    false    245            �            1259    25651    equipo    TABLE     A  CREATE TABLE public.equipo (
    equipo_id integer NOT NULL,
    nombre_oficial character varying(50) NOT NULL,
    nombre_corto character varying(15) NOT NULL,
    seudonimo character varying(255),
    codigo_fifa character(3) NOT NULL,
    fecha_fundacion date NOT NULL,
    ubicacion character varying(255),
    numero_socios integer,
    num_titulos_ganados integer,
    participaciones_copas_mundiales integer,
    num_finales_jugadas integer,
    cuerpo_tecnico_id integer NOT NULL,
    confederacion_id smallint NOT NULL,
    pais_id integer NOT NULL,
    foto bytea
);
    DROP TABLE public.equipo;
       public         heap    postgres    false            �            1259    25656    equipo_equipo_id_seq    SEQUENCE     �   CREATE SEQUENCE public.equipo_equipo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.equipo_equipo_id_seq;
       public          postgres    false    246                       0    0    equipo_equipo_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.equipo_equipo_id_seq OWNED BY public.equipo.equipo_id;
          public          postgres    false    247            �            1259    25657    estadio    TABLE     �  CREATE TABLE public.estadio (
    estadio_id integer NOT NULL,
    nombre_oficial character varying(150) NOT NULL,
    nombre_conocido character varying(50),
    capacidad integer NOT NULL,
    direccion character varying(255),
    fecha_fundacion date,
    numero_tribunas smallint NOT NULL,
    foto bytea,
    costo double precision,
    equipo_propietario character varying(100),
    dimension_id smallint NOT NULL,
    ciudad_id integer NOT NULL
);
    DROP TABLE public.estadio;
       public         heap    postgres    false            �            1259    25662    estadio_estadio_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estadio_estadio_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.estadio_estadio_id_seq;
       public          postgres    false    248                       0    0    estadio_estadio_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.estadio_estadio_id_seq OWNED BY public.estadio.estadio_id;
          public          postgres    false    249            �            1259    25663    etapa_fixture    TABLE     �   CREATE TABLE public.etapa_fixture (
    etapa_fixture_id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    fixture_id integer NOT NULL
);
 !   DROP TABLE public.etapa_fixture;
       public         heap    postgres    false            �            1259    25666 "   etapa_fixture_etapa_fixture_id_seq    SEQUENCE     �   CREATE SEQUENCE public.etapa_fixture_etapa_fixture_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.etapa_fixture_etapa_fixture_id_seq;
       public          postgres    false    250                       0    0 "   etapa_fixture_etapa_fixture_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE public.etapa_fixture_etapa_fixture_id_seq OWNED BY public.etapa_fixture.etapa_fixture_id;
          public          postgres    false    251            �            1259    25667    evento    TABLE     j   CREATE TABLE public.evento (
    evento_id integer NOT NULL,
    nombre character varying(50) NOT NULL
);
    DROP TABLE public.evento;
       public         heap    postgres    false            �            1259    25670    evento_evento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.evento_evento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.evento_evento_id_seq;
       public          postgres    false    252                       0    0    evento_evento_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.evento_evento_id_seq OWNED BY public.evento.evento_id;
          public          postgres    false    253            �            1259    25671    fixture    TABLE     m   CREATE TABLE public.fixture (
    fixture_id integer NOT NULL,
    nombre character varying(255) NOT NULL
);
    DROP TABLE public.fixture;
       public         heap    postgres    false            �            1259    25674    fixture_fixture_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fixture_fixture_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.fixture_fixture_id_seq;
       public          postgres    false    254                       0    0    fixture_fixture_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.fixture_fixture_id_seq OWNED BY public.fixture.fixture_id;
          public          postgres    false    255                        1259    25675    formacion_equipo    TABLE     |   CREATE TABLE public.formacion_equipo (
    formacion_id integer NOT NULL,
    descripcion character varying(10) NOT NULL
);
 $   DROP TABLE public.formacion_equipo;
       public         heap    postgres    false                       1259    25678 !   formacion_equipo_formacion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.formacion_equipo_formacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.formacion_equipo_formacion_id_seq;
       public          postgres    false    256                       0    0 !   formacion_equipo_formacion_id_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.formacion_equipo_formacion_id_seq OWNED BY public.formacion_equipo.formacion_id;
          public          postgres    false    257                       1259    25679 
   futbolista    TABLE     �  CREATE TABLE public.futbolista (
    futbolista_id integer NOT NULL,
    numero_documento_identidad character varying(25),
    nombre_completo character varying(50) NOT NULL,
    nombre_corto character varying(15) NOT NULL,
    fecha_nacimiento date NOT NULL,
    numero_camiseta integer NOT NULL,
    valor_mercado double precision,
    altura real NOT NULL,
    peso real NOT NULL,
    email character varying(255),
    foto character varying(255),
    tipo_doc_identidad_id smallint
);
    DROP TABLE public.futbolista;
       public         heap    postgres    false                       1259    25684    futbolista_futbolista_id_seq    SEQUENCE     �   CREATE SEQUENCE public.futbolista_futbolista_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.futbolista_futbolista_id_seq;
       public          postgres    false    258                       0    0    futbolista_futbolista_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.futbolista_futbolista_id_seq OWNED BY public.futbolista.futbolista_id;
          public          postgres    false    259                       1259    25685    grupo    TABLE     �   CREATE TABLE public.grupo (
    grupo_id integer NOT NULL,
    nombre character varying(255) NOT NULL,
    abreviatura character varying(10) NOT NULL
);
    DROP TABLE public.grupo;
       public         heap    postgres    false                       1259    25688    grupo_grupo_id_seq    SEQUENCE     �   CREATE SEQUENCE public.grupo_grupo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.grupo_grupo_id_seq;
       public          postgres    false    260                       0    0    grupo_grupo_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.grupo_grupo_id_seq OWNED BY public.grupo.grupo_id;
          public          postgres    false    261                       1259    25689    incidencia_partido    TABLE     '  CREATE TABLE public.incidencia_partido (
    evento_id integer NOT NULL,
    partido_id integer NOT NULL,
    futbolista_id integer NOT NULL,
    instancia_partido_id integer NOT NULL,
    minuto integer NOT NULL,
    equipo_id integer NOT NULL,
    detalle_incidencia character varying(255)
);
 &   DROP TABLE public.incidencia_partido;
       public         heap    postgres    false                       1259    25692    instancia_partido    TABLE     �   CREATE TABLE public.instancia_partido (
    instancia_partido_id integer NOT NULL,
    descripcion character varying(50) NOT NULL
);
 %   DROP TABLE public.instancia_partido;
       public         heap    postgres    false                       1259    25695 *   instancia_partido_instancia_partido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.instancia_partido_instancia_partido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 A   DROP SEQUENCE public.instancia_partido_instancia_partido_id_seq;
       public          postgres    false    263                       0    0 *   instancia_partido_instancia_partido_id_seq    SEQUENCE OWNED BY     y   ALTER SEQUENCE public.instancia_partido_instancia_partido_id_seq OWNED BY public.instancia_partido.instancia_partido_id;
          public          postgres    false    264            	           1259    25696    jornada    TABLE     �   CREATE TABLE public.jornada (
    jornada_id integer NOT NULL,
    nombre_jornada character varying(50) NOT NULL,
    fecha_larga character varying(255),
    fecha_corta date NOT NULL
);
    DROP TABLE public.jornada;
       public         heap    postgres    false            
           1259    25699    jornada_jornada_id_seq    SEQUENCE     �   CREATE SEQUENCE public.jornada_jornada_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.jornada_jornada_id_seq;
       public          postgres    false    265                        0    0    jornada_jornada_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.jornada_jornada_id_seq OWNED BY public.jornada.jornada_id;
          public          postgres    false    266                       1259    25700    pais    TABLE     �   CREATE TABLE public.pais (
    pais_id integer NOT NULL,
    nombre character varying(25) NOT NULL,
    codigo_iso character(3),
    continente_id smallint NOT NULL
);
    DROP TABLE public.pais;
       public         heap    postgres    false                       1259    25703    pais_pais_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pais_pais_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pais_pais_id_seq;
       public          postgres    false    267            !           0    0    pais_pais_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.pais_pais_id_seq OWNED BY public.pais.pais_id;
          public          postgres    false    268                       1259    25704    partido    TABLE     $  CREATE TABLE public.partido (
    partido_id integer NOT NULL,
    hora time(6) without time zone NOT NULL,
    jornada_id integer NOT NULL,
    estadio_id integer NOT NULL,
    etapa_fixture_id integer NOT NULL,
    competencia_id integer NOT NULL,
    terna_arbitral_id integer NOT NULL
);
    DROP TABLE public.partido;
       public         heap    postgres    false                       1259    25707    partido_partido_id_seq    SEQUENCE     �   CREATE SEQUENCE public.partido_partido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.partido_partido_id_seq;
       public          postgres    false    269            "           0    0    partido_partido_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.partido_partido_id_seq OWNED BY public.partido.partido_id;
          public          postgres    false    270                       1259    25708    permiso    TABLE     q   CREATE TABLE public.permiso (
    permiso_id integer NOT NULL,
    descripcion character varying(50) NOT NULL
);
    DROP TABLE public.permiso;
       public         heap    postgres    false                       1259    25711    permiso_permiso_id_seq    SEQUENCE     �   CREATE SEQUENCE public.permiso_permiso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.permiso_permiso_id_seq;
       public          postgres    false    271            #           0    0    permiso_permiso_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.permiso_permiso_id_seq OWNED BY public.permiso.permiso_id;
          public          postgres    false    272                       1259    25712    posicion    TABLE     �   CREATE TABLE public.posicion (
    posicion_id integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    abreviatura character varying(3) NOT NULL
);
    DROP TABLE public.posicion;
       public         heap    postgres    false                       1259    25715 #   posicion_futbolista_posicion_id_seq    SEQUENCE     �   CREATE SEQUENCE public.posicion_futbolista_posicion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.posicion_futbolista_posicion_id_seq;
       public          postgres    false    273            $           0    0 #   posicion_futbolista_posicion_id_seq    SEQUENCE OWNED BY     `   ALTER SEQUENCE public.posicion_futbolista_posicion_id_seq OWNED BY public.posicion.posicion_id;
          public          postgres    false    274                       1259    25716    profesional    TABLE     T  CREATE TABLE public.profesional (
    profesional_id integer NOT NULL,
    nombre_completo character varying(50) NOT NULL,
    fecha_nacimiento date,
    estado character(1),
    seudonimo character varying(50),
    fecha_debut date,
    palmares character varying(255),
    rercords character varying(255),
    pais_id integer NOT NULL
);
    DROP TABLE public.profesional;
       public         heap    postgres    false                       1259    25721    profesional_profesional_id_seq    SEQUENCE     �   CREATE SEQUENCE public.profesional_profesional_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.profesional_profesional_id_seq;
       public          postgres    false    275            %           0    0    profesional_profesional_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.profesional_profesional_id_seq OWNED BY public.profesional.profesional_id;
          public          postgres    false    276                       1259    25722    rol    TABLE     d   CREATE TABLE public.rol (
    rol_id integer NOT NULL,
    nombre character varying(50) NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false                       1259    25725    rol_permiso    TABLE     b   CREATE TABLE public.rol_permiso (
    rol_id integer NOT NULL,
    permiso_id integer NOT NULL
);
    DROP TABLE public.rol_permiso;
       public         heap    postgres    false                       1259    25728    rol_rol_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rol_rol_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.rol_rol_id_seq;
       public          postgres    false    277            &           0    0    rol_rol_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.rol_rol_id_seq OWNED BY public.rol.rol_id;
          public          postgres    false    279                       1259    25729    terna_arbitral    TABLE     r   CREATE TABLE public.terna_arbitral (
    terna_arbitral_id integer NOT NULL,
    nombre character varying(100)
);
 "   DROP TABLE public.terna_arbitral;
       public         heap    postgres    false                       1259    25732 $   terna_arbitral_terna_arbitral_id_seq    SEQUENCE     �   CREATE SEQUENCE public.terna_arbitral_terna_arbitral_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.terna_arbitral_terna_arbitral_id_seq;
       public          postgres    false    280            '           0    0 $   terna_arbitral_terna_arbitral_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.terna_arbitral_terna_arbitral_id_seq OWNED BY public.terna_arbitral.terna_arbitral_id;
          public          postgres    false    281                       1259    25733    tipo_documento_identidad    TABLE     �   CREATE TABLE public.tipo_documento_identidad (
    tipo_doc_identidad_id integer NOT NULL,
    descripcion_larga character varying(100) NOT NULL,
    abreviatura character(3) NOT NULL
);
 ,   DROP TABLE public.tipo_documento_identidad;
       public         heap    postgres    false                       1259    25736 2   tipo_documento_identidad_tipo_doc_identidad_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_documento_identidad_tipo_doc_identidad_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 I   DROP SEQUENCE public.tipo_documento_identidad_tipo_doc_identidad_id_seq;
       public          postgres    false    282            (           0    0 2   tipo_documento_identidad_tipo_doc_identidad_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.tipo_documento_identidad_tipo_doc_identidad_id_seq OWNED BY public.tipo_documento_identidad.tipo_doc_identidad_id;
          public          postgres    false    283                       1259    25737    tipo_jugador    TABLE     �   CREATE TABLE public.tipo_jugador (
    tipo_jugador_id integer NOT NULL,
    descripcion character varying(30) NOT NULL,
    sigla character(1) NOT NULL
);
     DROP TABLE public.tipo_jugador;
       public         heap    postgres    false                       1259    25740     tipo_jugador_tipo_jugador_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_jugador_tipo_jugador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.tipo_jugador_tipo_jugador_id_seq;
       public          postgres    false    284            )           0    0     tipo_jugador_tipo_jugador_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.tipo_jugador_tipo_jugador_id_seq OWNED BY public.tipo_jugador.tipo_jugador_id;
          public          postgres    false    285                       1259    25741    tipo_profesional    TABLE     �   CREATE TABLE public.tipo_profesional (
    tipo_profesional_id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    abreviatura character(3) NOT NULL
);
 $   DROP TABLE public.tipo_profesional;
       public         heap    postgres    false                       1259    25744 (   tipo_profesional_tipo_profesional_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_profesional_tipo_profesional_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.tipo_profesional_tipo_profesional_id_seq;
       public          postgres    false    286            *           0    0 (   tipo_profesional_tipo_profesional_id_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public.tipo_profesional_tipo_profesional_id_seq OWNED BY public.tipo_profesional.tipo_profesional_id;
          public          postgres    false    287                        1259    25745    tipo_terna_arbitral    TABLE     �   CREATE TABLE public.tipo_terna_arbitral (
    tipo_terna_arbitral_id integer NOT NULL,
    descripcion character varying(50) NOT NULL
);
 '   DROP TABLE public.tipo_terna_arbitral;
       public         heap    postgres    false            !           1259    25748 .   tipo_terna_arbitral_tipo_terna_arbitral_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_terna_arbitral_tipo_terna_arbitral_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 E   DROP SEQUENCE public.tipo_terna_arbitral_tipo_terna_arbitral_id_seq;
       public          postgres    false    288            +           0    0 .   tipo_terna_arbitral_tipo_terna_arbitral_id_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.tipo_terna_arbitral_tipo_terna_arbitral_id_seq OWNED BY public.tipo_terna_arbitral.tipo_terna_arbitral_id;
          public          postgres    false    289            "           1259    25749    usuario    TABLE       CREATE TABLE public.usuario (
    usuario_id integer NOT NULL,
    rol_id integer NOT NULL,
    nombre character varying(50) NOT NULL,
    documento_identidad character varying(20) NOT NULL,
    password character varying(255) NOT NULL,
    fecha_creacion date NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            :           2604    25752    arbitro arbitro_id    DEFAULT     x   ALTER TABLE ONLY public.arbitro ALTER COLUMN arbitro_id SET DEFAULT nextval('public.arbitro_arbitro_id_seq'::regclass);
 A   ALTER TABLE public.arbitro ALTER COLUMN arbitro_id DROP DEFAULT;
       public          postgres    false    216    215            ;           2604    25753 &   categoria_arbitro categoria_arbitro_id    DEFAULT     �   ALTER TABLE ONLY public.categoria_arbitro ALTER COLUMN categoria_arbitro_id SET DEFAULT nextval('public.categoria_arbitro_categoria_arbitro_id_seq'::regclass);
 U   ALTER TABLE public.categoria_arbitro ALTER COLUMN categoria_arbitro_id DROP DEFAULT;
       public          postgres    false    218    217            <           2604    25754    ciudad ciudad_id    DEFAULT     t   ALTER TABLE ONLY public.ciudad ALTER COLUMN ciudad_id SET DEFAULT nextval('public.ciudad_ciudad_id_seq'::regclass);
 ?   ALTER TABLE public.ciudad ALTER COLUMN ciudad_id DROP DEFAULT;
       public          postgres    false    220    219            =           2604    25755    competencia competencia_id    DEFAULT     �   ALTER TABLE ONLY public.competencia ALTER COLUMN competencia_id SET DEFAULT nextval('public.competencia_competencia_id_seq'::regclass);
 I   ALTER TABLE public.competencia ALTER COLUMN competencia_id DROP DEFAULT;
       public          postgres    false    222    221            >           2604    25756 %   confederacion_futbol confederacion_id    DEFAULT     �   ALTER TABLE ONLY public.confederacion_futbol ALTER COLUMN confederacion_id SET DEFAULT nextval('public.confederacion_futbol_confederacion_id_seq'::regclass);
 T   ALTER TABLE public.confederacion_futbol ALTER COLUMN confederacion_id DROP DEFAULT;
       public          postgres    false    224    223            ?           2604    25757    continente continente_id    DEFAULT     �   ALTER TABLE ONLY public.continente ALTER COLUMN continente_id SET DEFAULT nextval('public.continente_continente_id_seq'::regclass);
 G   ALTER TABLE public.continente ALTER COLUMN continente_id DROP DEFAULT;
       public          postgres    false    226    225            @           2604    25758    contrato_futbol contrato_id    DEFAULT     �   ALTER TABLE ONLY public.contrato_futbol ALTER COLUMN contrato_id SET DEFAULT nextval('public.contrato_futbol_contrato_id_seq'::regclass);
 J   ALTER TABLE public.contrato_futbol ALTER COLUMN contrato_id DROP DEFAULT;
       public          postgres    false    228    227            A           2604    25759     cuerpo_tecnico cuerpo_tecnico_id    DEFAULT     �   ALTER TABLE ONLY public.cuerpo_tecnico ALTER COLUMN cuerpo_tecnico_id SET DEFAULT nextval('public.cuerpo_tecnico_cuerpo_tecnico_id_seq'::regclass);
 O   ALTER TABLE public.cuerpo_tecnico ALTER COLUMN cuerpo_tecnico_id DROP DEFAULT;
       public          postgres    false    230    229            B           2604    25760    dimension_campo dimension_id    DEFAULT     �   ALTER TABLE ONLY public.dimension_campo ALTER COLUMN dimension_id SET DEFAULT nextval('public.dimension_campo_dimension_id_seq'::regclass);
 K   ALTER TABLE public.dimension_campo ALTER COLUMN dimension_id DROP DEFAULT;
       public          postgres    false    245    244            C           2604    25761    equipo equipo_id    DEFAULT     t   ALTER TABLE ONLY public.equipo ALTER COLUMN equipo_id SET DEFAULT nextval('public.equipo_equipo_id_seq'::regclass);
 ?   ALTER TABLE public.equipo ALTER COLUMN equipo_id DROP DEFAULT;
       public          postgres    false    247    246            D           2604    25762    estadio estadio_id    DEFAULT     x   ALTER TABLE ONLY public.estadio ALTER COLUMN estadio_id SET DEFAULT nextval('public.estadio_estadio_id_seq'::regclass);
 A   ALTER TABLE public.estadio ALTER COLUMN estadio_id DROP DEFAULT;
       public          postgres    false    249    248            E           2604    25763    etapa_fixture etapa_fixture_id    DEFAULT     �   ALTER TABLE ONLY public.etapa_fixture ALTER COLUMN etapa_fixture_id SET DEFAULT nextval('public.etapa_fixture_etapa_fixture_id_seq'::regclass);
 M   ALTER TABLE public.etapa_fixture ALTER COLUMN etapa_fixture_id DROP DEFAULT;
       public          postgres    false    251    250            F           2604    25764    evento evento_id    DEFAULT     t   ALTER TABLE ONLY public.evento ALTER COLUMN evento_id SET DEFAULT nextval('public.evento_evento_id_seq'::regclass);
 ?   ALTER TABLE public.evento ALTER COLUMN evento_id DROP DEFAULT;
       public          postgres    false    253    252            G           2604    25765    fixture fixture_id    DEFAULT     x   ALTER TABLE ONLY public.fixture ALTER COLUMN fixture_id SET DEFAULT nextval('public.fixture_fixture_id_seq'::regclass);
 A   ALTER TABLE public.fixture ALTER COLUMN fixture_id DROP DEFAULT;
       public          postgres    false    255    254            H           2604    25766    formacion_equipo formacion_id    DEFAULT     �   ALTER TABLE ONLY public.formacion_equipo ALTER COLUMN formacion_id SET DEFAULT nextval('public.formacion_equipo_formacion_id_seq'::regclass);
 L   ALTER TABLE public.formacion_equipo ALTER COLUMN formacion_id DROP DEFAULT;
       public          postgres    false    257    256            I           2604    25767    futbolista futbolista_id    DEFAULT     �   ALTER TABLE ONLY public.futbolista ALTER COLUMN futbolista_id SET DEFAULT nextval('public.futbolista_futbolista_id_seq'::regclass);
 G   ALTER TABLE public.futbolista ALTER COLUMN futbolista_id DROP DEFAULT;
       public          postgres    false    259    258            J           2604    25768    grupo grupo_id    DEFAULT     p   ALTER TABLE ONLY public.grupo ALTER COLUMN grupo_id SET DEFAULT nextval('public.grupo_grupo_id_seq'::regclass);
 =   ALTER TABLE public.grupo ALTER COLUMN grupo_id DROP DEFAULT;
       public          postgres    false    261    260            K           2604    25769 &   instancia_partido instancia_partido_id    DEFAULT     �   ALTER TABLE ONLY public.instancia_partido ALTER COLUMN instancia_partido_id SET DEFAULT nextval('public.instancia_partido_instancia_partido_id_seq'::regclass);
 U   ALTER TABLE public.instancia_partido ALTER COLUMN instancia_partido_id DROP DEFAULT;
       public          postgres    false    264    263            L           2604    25770    jornada jornada_id    DEFAULT     x   ALTER TABLE ONLY public.jornada ALTER COLUMN jornada_id SET DEFAULT nextval('public.jornada_jornada_id_seq'::regclass);
 A   ALTER TABLE public.jornada ALTER COLUMN jornada_id DROP DEFAULT;
       public          postgres    false    266    265            M           2604    25771    pais pais_id    DEFAULT     l   ALTER TABLE ONLY public.pais ALTER COLUMN pais_id SET DEFAULT nextval('public.pais_pais_id_seq'::regclass);
 ;   ALTER TABLE public.pais ALTER COLUMN pais_id DROP DEFAULT;
       public          postgres    false    268    267            N           2604    25772    partido partido_id    DEFAULT     x   ALTER TABLE ONLY public.partido ALTER COLUMN partido_id SET DEFAULT nextval('public.partido_partido_id_seq'::regclass);
 A   ALTER TABLE public.partido ALTER COLUMN partido_id DROP DEFAULT;
       public          postgres    false    270    269            O           2604    25773    permiso permiso_id    DEFAULT     x   ALTER TABLE ONLY public.permiso ALTER COLUMN permiso_id SET DEFAULT nextval('public.permiso_permiso_id_seq'::regclass);
 A   ALTER TABLE public.permiso ALTER COLUMN permiso_id DROP DEFAULT;
       public          postgres    false    272    271            P           2604    25774    posicion posicion_id    DEFAULT     �   ALTER TABLE ONLY public.posicion ALTER COLUMN posicion_id SET DEFAULT nextval('public.posicion_futbolista_posicion_id_seq'::regclass);
 C   ALTER TABLE public.posicion ALTER COLUMN posicion_id DROP DEFAULT;
       public          postgres    false    274    273            Q           2604    25775    profesional profesional_id    DEFAULT     �   ALTER TABLE ONLY public.profesional ALTER COLUMN profesional_id SET DEFAULT nextval('public.profesional_profesional_id_seq'::regclass);
 I   ALTER TABLE public.profesional ALTER COLUMN profesional_id DROP DEFAULT;
       public          postgres    false    276    275            R           2604    25776 
   rol rol_id    DEFAULT     h   ALTER TABLE ONLY public.rol ALTER COLUMN rol_id SET DEFAULT nextval('public.rol_rol_id_seq'::regclass);
 9   ALTER TABLE public.rol ALTER COLUMN rol_id DROP DEFAULT;
       public          postgres    false    279    277            S           2604    25777     terna_arbitral terna_arbitral_id    DEFAULT     �   ALTER TABLE ONLY public.terna_arbitral ALTER COLUMN terna_arbitral_id SET DEFAULT nextval('public.terna_arbitral_terna_arbitral_id_seq'::regclass);
 O   ALTER TABLE public.terna_arbitral ALTER COLUMN terna_arbitral_id DROP DEFAULT;
       public          postgres    false    281    280            T           2604    25778 .   tipo_documento_identidad tipo_doc_identidad_id    DEFAULT     �   ALTER TABLE ONLY public.tipo_documento_identidad ALTER COLUMN tipo_doc_identidad_id SET DEFAULT nextval('public.tipo_documento_identidad_tipo_doc_identidad_id_seq'::regclass);
 ]   ALTER TABLE public.tipo_documento_identidad ALTER COLUMN tipo_doc_identidad_id DROP DEFAULT;
       public          postgres    false    283    282            U           2604    25779    tipo_jugador tipo_jugador_id    DEFAULT     �   ALTER TABLE ONLY public.tipo_jugador ALTER COLUMN tipo_jugador_id SET DEFAULT nextval('public.tipo_jugador_tipo_jugador_id_seq'::regclass);
 K   ALTER TABLE public.tipo_jugador ALTER COLUMN tipo_jugador_id DROP DEFAULT;
       public          postgres    false    285    284            V           2604    25780 $   tipo_profesional tipo_profesional_id    DEFAULT     �   ALTER TABLE ONLY public.tipo_profesional ALTER COLUMN tipo_profesional_id SET DEFAULT nextval('public.tipo_profesional_tipo_profesional_id_seq'::regclass);
 S   ALTER TABLE public.tipo_profesional ALTER COLUMN tipo_profesional_id DROP DEFAULT;
       public          postgres    false    287    286            W           2604    25781 *   tipo_terna_arbitral tipo_terna_arbitral_id    DEFAULT     �   ALTER TABLE ONLY public.tipo_terna_arbitral ALTER COLUMN tipo_terna_arbitral_id SET DEFAULT nextval('public.tipo_terna_arbitral_tipo_terna_arbitral_id_seq'::regclass);
 Y   ALTER TABLE public.tipo_terna_arbitral ALTER COLUMN tipo_terna_arbitral_id DROP DEFAULT;
       public          postgres    false    289    288            �          0    25566 
   alineacion 
   TABLE DATA           h   COPY public.alineacion (partido_id, equipo_id, futbolista_id, tipo_jugador_id, posicion_id) FROM stdin;
    public          postgres    false    214   ��      �          0    25569    arbitro 
   TABLE DATA           V   COPY public.arbitro (arbitro_id, arbitro_nombre, estado_arbitro, pais_id) FROM stdin;
    public          postgres    false    215   .�      �          0    25573    categoria_arbitro 
   TABLE DATA           h   COPY public.categoria_arbitro (categoria_arbitro_id, nombre, sigla, tipo_terna_arbitral_id) FROM stdin;
    public          postgres    false    217   ��      �          0    25577    ciudad 
   TABLE DATA           E   COPY public.ciudad (ciudad_id, nombre_completo, pais_id) FROM stdin;
    public          postgres    false    219   R�      �          0    25581    competencia 
   TABLE DATA           b   COPY public.competencia (competencia_id, nombre, fecha_inicio, fecha_fin, fixture_id) FROM stdin;
    public          postgres    false    221   ��      �          0    25585    confederacion_futbol 
   TABLE DATA           �   COPY public.confederacion_futbol (confederacion_id, nombre_oficial, acronimo, ubicacion, sede, fecha_fundacion, numero_federaciones_afiliadas) FROM stdin;
    public          postgres    false    223   ��      �          0    25591 
   continente 
   TABLE DATA           H   COPY public.continente (continente_id, nombre, abreviatura) FROM stdin;
    public          postgres    false    225   G�      �          0    25595    contrato_futbol 
   TABLE DATA           y   COPY public.contrato_futbol (contrato_id, fecha_inicio, fecha_fin, remuneracion, descripcion, futbolista_id) FROM stdin;
    public          postgres    false    227   ��      �          0    25599    cuerpo_tecnico 
   TABLE DATA           h   COPY public.cuerpo_tecnico (cuerpo_tecnico_id, nombre, profesional_id, tipo_profesional_id) FROM stdin;
    public          postgres    false    229   ��      �          0    25603    detalle_arbitro_terna_arbitral 
   TABLE DATA           m   COPY public.detalle_arbitro_terna_arbitral (arbitro_id, terna_arbitral_id, categoria_arbitro_id) FROM stdin;
    public          postgres    false    231   ��      �          0    25606    detalle_categoria_arbitro 
   TABLE DATA           U   COPY public.detalle_categoria_arbitro (arbitro_id, categoria_arbitro_id) FROM stdin;
    public          postgres    false    232   ��      �          0    25609    detalle_competencia_equipo 
   TABLE DATA           O   COPY public.detalle_competencia_equipo (competencia_id, equipo_id) FROM stdin;
    public          postgres    false    233   ��      �          0    25612    detalle_competencia_grupo 
   TABLE DATA           M   COPY public.detalle_competencia_grupo (grupo_id, competencia_id) FROM stdin;
    public          postgres    false    234   0�      �          0    25618    detalle_equipo 
   TABLE DATA           O   COPY public.detalle_equipo (equipo_id, futbolista_id, posicion_id) FROM stdin;
    public          postgres    false    235   X�      �          0    25621    detalle_equipo_futbolista 
   TABLE DATA           ]   COPY public.detalle_equipo_futbolista (equipo_id, futbolista_id, competencia_id) FROM stdin;
    public          postgres    false    236   ��      �          0    25624    detalle_grupo 
   TABLE DATA           Z   COPY public.detalle_grupo (grupo_id, equipo_id, pj, g, e, p, gf, gc, df, pts) FROM stdin;
    public          postgres    false    237   ��      �          0    25627     detalle_organizacion_competencia 
   TABLE DATA           S   COPY public.detalle_organizacion_competencia (pais_id, competencia_id) FROM stdin;
    public          postgres    false    238   ��      �          0    25630    detalle_pais_futbolista 
   TABLE DATA           I   COPY public.detalle_pais_futbolista (futbolista_id, pais_id) FROM stdin;
    public          postgres    false    239   �      �          0    25633    detalle_partido 
   TABLE DATA           &  COPY public.detalle_partido (partido_id, equipo_id, tipo, goles, posesion_balon, numero_faltas, tarjetas_amarillas, tarjetas_rojas, tiros, tiros_puerta, fuera_de_lugar, tiros_esquina, pases_completados, cambios, dato_curioso, distancia_recorrida, balones_recuperados, formacion_id) FROM stdin;
    public          postgres    false    240   D�      �          0    25638    detalle_posicion_futbolista 
   TABLE DATA           Q   COPY public.detalle_posicion_futbolista (futbolista_id, posicion_id) FROM stdin;
    public          postgres    false    241   ��      �          0    25641    detalle_profesional 
   TABLE DATA           R   COPY public.detalle_profesional (profesional_id, tipo_profesional_id) FROM stdin;
    public          postgres    false    242   ��      �          0    25644    detalle_terna_arbitral 
   TABLE DATA           [   COPY public.detalle_terna_arbitral (terna_arbitral_id, tipo_terna_arbitral_id) FROM stdin;
    public          postgres    false    243   	�      �          0    25647    dimension_campo 
   TABLE DATA           D   COPY public.dimension_campo (dimension_id, descripcion) FROM stdin;
    public          postgres    false    244   3�      �          0    25651    equipo 
   TABLE DATA             COPY public.equipo (equipo_id, nombre_oficial, nombre_corto, seudonimo, codigo_fifa, fecha_fundacion, ubicacion, numero_socios, num_titulos_ganados, participaciones_copas_mundiales, num_finales_jugadas, cuerpo_tecnico_id, confederacion_id, pais_id, foto) FROM stdin;
    public          postgres    false    246   v�      �          0    25657    estadio 
   TABLE DATA           �   COPY public.estadio (estadio_id, nombre_oficial, nombre_conocido, capacidad, direccion, fecha_fundacion, numero_tribunas, foto, costo, equipo_propietario, dimension_id, ciudad_id) FROM stdin;
    public          postgres    false    248   0t      �          0    25663    etapa_fixture 
   TABLE DATA           R   COPY public.etapa_fixture (etapa_fixture_id, descripcion, fixture_id) FROM stdin;
    public          postgres    false    250   �t      �          0    25667    evento 
   TABLE DATA           3   COPY public.evento (evento_id, nombre) FROM stdin;
    public          postgres    false    252   +u      �          0    25671    fixture 
   TABLE DATA           5   COPY public.fixture (fixture_id, nombre) FROM stdin;
    public          postgres    false    254   �u      �          0    25675    formacion_equipo 
   TABLE DATA           E   COPY public.formacion_equipo (formacion_id, descripcion) FROM stdin;
    public          postgres    false    256   :v      �          0    25679 
   futbolista 
   TABLE DATA           �   COPY public.futbolista (futbolista_id, numero_documento_identidad, nombre_completo, nombre_corto, fecha_nacimiento, numero_camiseta, valor_mercado, altura, peso, email, foto, tipo_doc_identidad_id) FROM stdin;
    public          postgres    false    258   wv      �          0    25685    grupo 
   TABLE DATA           >   COPY public.grupo (grupo_id, nombre, abreviatura) FROM stdin;
    public          postgres    false    260   ww      �          0    25689    incidencia_partido 
   TABLE DATA           �   COPY public.incidencia_partido (evento_id, partido_id, futbolista_id, instancia_partido_id, minuto, equipo_id, detalle_incidencia) FROM stdin;
    public          postgres    false    262   x      �          0    25692    instancia_partido 
   TABLE DATA           N   COPY public.instancia_partido (instancia_partido_id, descripcion) FROM stdin;
    public          postgres    false    263   fx      �          0    25696    jornada 
   TABLE DATA           W   COPY public.jornada (jornada_id, nombre_jornada, fecha_larga, fecha_corta) FROM stdin;
    public          postgres    false    265   �x      �          0    25700    pais 
   TABLE DATA           J   COPY public.pais (pais_id, nombre, codigo_iso, continente_id) FROM stdin;
    public          postgres    false    267   Ky      �          0    25704    partido 
   TABLE DATA           �   COPY public.partido (partido_id, hora, jornada_id, estadio_id, etapa_fixture_id, competencia_id, terna_arbitral_id) FROM stdin;
    public          postgres    false    269   {      �          0    25708    permiso 
   TABLE DATA           :   COPY public.permiso (permiso_id, descripcion) FROM stdin;
    public          postgres    false    271   ^{      �          0    25712    posicion 
   TABLE DATA           I   COPY public.posicion (posicion_id, descripcion, abreviatura) FROM stdin;
    public          postgres    false    273   �{      �          0    25716    profesional 
   TABLE DATA           �   COPY public.profesional (profesional_id, nombre_completo, fecha_nacimiento, estado, seudonimo, fecha_debut, palmares, rercords, pais_id) FROM stdin;
    public          postgres    false    275   e|      �          0    25722    rol 
   TABLE DATA           -   COPY public.rol (rol_id, nombre) FROM stdin;
    public          postgres    false    277   *}      �          0    25725    rol_permiso 
   TABLE DATA           9   COPY public.rol_permiso (rol_id, permiso_id) FROM stdin;
    public          postgres    false    278   u}      �          0    25729    terna_arbitral 
   TABLE DATA           C   COPY public.terna_arbitral (terna_arbitral_id, nombre) FROM stdin;
    public          postgres    false    280   �}      �          0    25733    tipo_documento_identidad 
   TABLE DATA           i   COPY public.tipo_documento_identidad (tipo_doc_identidad_id, descripcion_larga, abreviatura) FROM stdin;
    public          postgres    false    282   �}                0    25737    tipo_jugador 
   TABLE DATA           K   COPY public.tipo_jugador (tipo_jugador_id, descripcion, sigla) FROM stdin;
    public          postgres    false    284   B~                0    25741    tipo_profesional 
   TABLE DATA           T   COPY public.tipo_profesional (tipo_profesional_id, nombre, abreviatura) FROM stdin;
    public          postgres    false    286   x~                0    25745    tipo_terna_arbitral 
   TABLE DATA           R   COPY public.tipo_terna_arbitral (tipo_terna_arbitral_id, descripcion) FROM stdin;
    public          postgres    false    288                    0    25749    usuario 
   TABLE DATA           l   COPY public.usuario (usuario_id, rol_id, nombre, documento_identidad, password, fecha_creacion) FROM stdin;
    public          postgres    false    290   .      ,           0    0    arbitro_arbitro_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.arbitro_arbitro_id_seq', 13, true);
          public          postgres    false    216            -           0    0 *   categoria_arbitro_categoria_arbitro_id_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.categoria_arbitro_categoria_arbitro_id_seq', 7, true);
          public          postgres    false    218            .           0    0    ciudad_ciudad_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ciudad_ciudad_id_seq', 11, true);
          public          postgres    false    220            /           0    0    competencia_competencia_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.competencia_competencia_id_seq', 12, true);
          public          postgres    false    222            0           0    0 )   confederacion_futbol_confederacion_id_seq    SEQUENCE SET     W   SELECT pg_catalog.setval('public.confederacion_futbol_confederacion_id_seq', 7, true);
          public          postgres    false    224            1           0    0    continente_continente_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.continente_continente_id_seq', 18, true);
          public          postgres    false    226            2           0    0    contrato_futbol_contrato_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.contrato_futbol_contrato_id_seq', 3, true);
          public          postgres    false    228            3           0    0 $   cuerpo_tecnico_cuerpo_tecnico_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.cuerpo_tecnico_cuerpo_tecnico_id_seq', 11, true);
          public          postgres    false    230            4           0    0     dimension_campo_dimension_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.dimension_campo_dimension_id_seq', 4, true);
          public          postgres    false    245            5           0    0    equipo_equipo_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.equipo_equipo_id_seq', 16, true);
          public          postgres    false    247            6           0    0    estadio_estadio_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.estadio_estadio_id_seq', 4, true);
          public          postgres    false    249            7           0    0 "   etapa_fixture_etapa_fixture_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.etapa_fixture_etapa_fixture_id_seq', 7, true);
          public          postgres    false    251            8           0    0    evento_evento_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.evento_evento_id_seq', 11, true);
          public          postgres    false    253            9           0    0    fixture_fixture_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.fixture_fixture_id_seq', 7, true);
          public          postgres    false    255            :           0    0 !   formacion_equipo_formacion_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.formacion_equipo_formacion_id_seq', 6, true);
          public          postgres    false    257            ;           0    0    futbolista_futbolista_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.futbolista_futbolista_id_seq', 8, true);
          public          postgres    false    259            <           0    0    grupo_grupo_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.grupo_grupo_id_seq', 17, true);
          public          postgres    false    261            =           0    0 *   instancia_partido_instancia_partido_id_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.instancia_partido_instancia_partido_id_seq', 6, true);
          public          postgres    false    264            >           0    0    jornada_jornada_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.jornada_jornada_id_seq', 5, true);
          public          postgres    false    266            ?           0    0    pais_pais_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.pais_pais_id_seq', 41, true);
          public          postgres    false    268            @           0    0    partido_partido_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.partido_partido_id_seq', 6, true);
          public          postgres    false    270            A           0    0    permiso_permiso_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.permiso_permiso_id_seq', 8, true);
          public          postgres    false    272            B           0    0 #   posicion_futbolista_posicion_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.posicion_futbolista_posicion_id_seq', 9, true);
          public          postgres    false    274            C           0    0    profesional_profesional_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.profesional_profesional_id_seq', 8, true);
          public          postgres    false    276            D           0    0    rol_rol_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.rol_rol_id_seq', 5, true);
          public          postgres    false    279            E           0    0 $   terna_arbitral_terna_arbitral_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.terna_arbitral_terna_arbitral_id_seq', 3, true);
          public          postgres    false    281            F           0    0 2   tipo_documento_identidad_tipo_doc_identidad_id_seq    SEQUENCE SET     `   SELECT pg_catalog.setval('public.tipo_documento_identidad_tipo_doc_identidad_id_seq', 3, true);
          public          postgres    false    283            G           0    0     tipo_jugador_tipo_jugador_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.tipo_jugador_tipo_jugador_id_seq', 3, true);
          public          postgres    false    285            H           0    0 (   tipo_profesional_tipo_profesional_id_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.tipo_profesional_tipo_profesional_id_seq', 8, true);
          public          postgres    false    287            I           0    0 .   tipo_terna_arbitral_tipo_terna_arbitral_id_seq    SEQUENCE SET     \   SELECT pg_catalog.setval('public.tipo_terna_arbitral_tipo_terna_arbitral_id_seq', 3, true);
          public          postgres    false    289            Y           2606    25783 !   alineacion alineacion_equipo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT alineacion_equipo_pkey PRIMARY KEY (partido_id, equipo_id, futbolista_id, tipo_jugador_id, posicion_id);
 K   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT alineacion_equipo_pkey;
       public            postgres    false    214    214    214    214    214            [           2606    25785    arbitro arbitro_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.arbitro
    ADD CONSTRAINT arbitro_pkey PRIMARY KEY (arbitro_id);
 >   ALTER TABLE ONLY public.arbitro DROP CONSTRAINT arbitro_pkey;
       public            postgres    false    215            ]           2606    25787 (   categoria_arbitro categoria_arbitro_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.categoria_arbitro
    ADD CONSTRAINT categoria_arbitro_pkey PRIMARY KEY (categoria_arbitro_id);
 R   ALTER TABLE ONLY public.categoria_arbitro DROP CONSTRAINT categoria_arbitro_pkey;
       public            postgres    false    217            _           2606    25789    ciudad ciudad_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (ciudad_id);
 <   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_pkey;
       public            postgres    false    219            a           2606    25791 &   competencia competencia_fixture_id_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.competencia
    ADD CONSTRAINT competencia_fixture_id_key UNIQUE (fixture_id);
 P   ALTER TABLE ONLY public.competencia DROP CONSTRAINT competencia_fixture_id_key;
       public            postgres    false    221            c           2606    25793    competencia competencia_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.competencia
    ADD CONSTRAINT competencia_pkey PRIMARY KEY (competencia_id);
 F   ALTER TABLE ONLY public.competencia DROP CONSTRAINT competencia_pkey;
       public            postgres    false    221            e           2606    25795 6   confederacion_futbol confederacion_futbol_acronimo_key 
   CONSTRAINT     u   ALTER TABLE ONLY public.confederacion_futbol
    ADD CONSTRAINT confederacion_futbol_acronimo_key UNIQUE (acronimo);
 `   ALTER TABLE ONLY public.confederacion_futbol DROP CONSTRAINT confederacion_futbol_acronimo_key;
       public            postgres    false    223            g           2606    25797 <   confederacion_futbol confederacion_futbol_nombre_oficial_key 
   CONSTRAINT     �   ALTER TABLE ONLY public.confederacion_futbol
    ADD CONSTRAINT confederacion_futbol_nombre_oficial_key UNIQUE (nombre_oficial);
 f   ALTER TABLE ONLY public.confederacion_futbol DROP CONSTRAINT confederacion_futbol_nombre_oficial_key;
       public            postgres    false    223            i           2606    25799 .   confederacion_futbol confederacion_futbol_pkey 
   CONSTRAINT     z   ALTER TABLE ONLY public.confederacion_futbol
    ADD CONSTRAINT confederacion_futbol_pkey PRIMARY KEY (confederacion_id);
 X   ALTER TABLE ONLY public.confederacion_futbol DROP CONSTRAINT confederacion_futbol_pkey;
       public            postgres    false    223            k           2606    25801 %   continente continente_abreviatura_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.continente
    ADD CONSTRAINT continente_abreviatura_key UNIQUE (abreviatura);
 O   ALTER TABLE ONLY public.continente DROP CONSTRAINT continente_abreviatura_key;
       public            postgres    false    225            m           2606    25803     continente continente_nombre_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.continente
    ADD CONSTRAINT continente_nombre_key UNIQUE (nombre);
 J   ALTER TABLE ONLY public.continente DROP CONSTRAINT continente_nombre_key;
       public            postgres    false    225            o           2606    25805    continente continente_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.continente
    ADD CONSTRAINT continente_pkey PRIMARY KEY (continente_id);
 D   ALTER TABLE ONLY public.continente DROP CONSTRAINT continente_pkey;
       public            postgres    false    225            q           2606    25807 $   contrato_futbol contrato_futbol_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY public.contrato_futbol
    ADD CONSTRAINT contrato_futbol_pkey PRIMARY KEY (contrato_id);
 N   ALTER TABLE ONLY public.contrato_futbol DROP CONSTRAINT contrato_futbol_pkey;
       public            postgres    false    227            s           2606    25809 "   cuerpo_tecnico cuerpo_tecnico_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.cuerpo_tecnico
    ADD CONSTRAINT cuerpo_tecnico_pkey PRIMARY KEY (cuerpo_tecnico_id);
 L   ALTER TABLE ONLY public.cuerpo_tecnico DROP CONSTRAINT cuerpo_tecnico_pkey;
       public            postgres    false    229            u           2606    25811 B   detalle_arbitro_terna_arbitral detalle_arbitro_terna_arbitral_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral
    ADD CONSTRAINT detalle_arbitro_terna_arbitral_pkey PRIMARY KEY (arbitro_id, terna_arbitral_id, categoria_arbitro_id);
 l   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral DROP CONSTRAINT detalle_arbitro_terna_arbitral_pkey;
       public            postgres    false    231    231    231            w           2606    25813 8   detalle_categoria_arbitro detalle_categoria_arbitro_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_categoria_arbitro
    ADD CONSTRAINT detalle_categoria_arbitro_pkey PRIMARY KEY (arbitro_id, categoria_arbitro_id);
 b   ALTER TABLE ONLY public.detalle_categoria_arbitro DROP CONSTRAINT detalle_categoria_arbitro_pkey;
       public            postgres    false    232    232            y           2606    25815 :   detalle_competencia_equipo detalle_competencia_equipo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_equipo
    ADD CONSTRAINT detalle_competencia_equipo_pkey PRIMARY KEY (competencia_id, equipo_id);
 d   ALTER TABLE ONLY public.detalle_competencia_equipo DROP CONSTRAINT detalle_competencia_equipo_pkey;
       public            postgres    false    233    233            {           2606    25817 8   detalle_competencia_grupo detalle_competencia_grupo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_grupo
    ADD CONSTRAINT detalle_competencia_grupo_pkey PRIMARY KEY (grupo_id, competencia_id);
 b   ALTER TABLE ONLY public.detalle_competencia_grupo DROP CONSTRAINT detalle_competencia_grupo_pkey;
       public            postgres    false    234    234                       2606    25823 8   detalle_equipo_futbolista detalle_equipo_futbolista_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo_futbolista
    ADD CONSTRAINT detalle_equipo_futbolista_pkey PRIMARY KEY (equipo_id, futbolista_id, competencia_id);
 b   ALTER TABLE ONLY public.detalle_equipo_futbolista DROP CONSTRAINT detalle_equipo_futbolista_pkey;
       public            postgres    false    236    236    236            }           2606    25825 "   detalle_equipo detalle_equipo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo
    ADD CONSTRAINT detalle_equipo_pkey PRIMARY KEY (equipo_id, futbolista_id, posicion_id);
 L   ALTER TABLE ONLY public.detalle_equipo DROP CONSTRAINT detalle_equipo_pkey;
       public            postgres    false    235    235    235            �           2606    25827     detalle_grupo detalle_grupo_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.detalle_grupo
    ADD CONSTRAINT detalle_grupo_pkey PRIMARY KEY (grupo_id, equipo_id);
 J   ALTER TABLE ONLY public.detalle_grupo DROP CONSTRAINT detalle_grupo_pkey;
       public            postgres    false    237    237            �           2606    25829 F   detalle_organizacion_competencia detalle_organizacion_competencia_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_organizacion_competencia
    ADD CONSTRAINT detalle_organizacion_competencia_pkey PRIMARY KEY (pais_id, competencia_id);
 p   ALTER TABLE ONLY public.detalle_organizacion_competencia DROP CONSTRAINT detalle_organizacion_competencia_pkey;
       public            postgres    false    238    238            �           2606    25831 4   detalle_pais_futbolista detalle_pais_futbolista_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_pais_futbolista
    ADD CONSTRAINT detalle_pais_futbolista_pkey PRIMARY KEY (futbolista_id, pais_id);
 ^   ALTER TABLE ONLY public.detalle_pais_futbolista DROP CONSTRAINT detalle_pais_futbolista_pkey;
       public            postgres    false    239    239            �           2606    25833 $   detalle_partido detalle_partido_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.detalle_partido
    ADD CONSTRAINT detalle_partido_pkey PRIMARY KEY (partido_id, equipo_id);
 N   ALTER TABLE ONLY public.detalle_partido DROP CONSTRAINT detalle_partido_pkey;
       public            postgres    false    240    240            �           2606    25835 <   detalle_posicion_futbolista detalle_posicion_futbolista_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_posicion_futbolista
    ADD CONSTRAINT detalle_posicion_futbolista_pkey PRIMARY KEY (futbolista_id, posicion_id);
 f   ALTER TABLE ONLY public.detalle_posicion_futbolista DROP CONSTRAINT detalle_posicion_futbolista_pkey;
       public            postgres    false    241    241            �           2606    25837 ,   detalle_profesional detalle_profesional_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_profesional
    ADD CONSTRAINT detalle_profesional_pkey PRIMARY KEY (profesional_id, tipo_profesional_id);
 V   ALTER TABLE ONLY public.detalle_profesional DROP CONSTRAINT detalle_profesional_pkey;
       public            postgres    false    242    242            �           2606    25839 2   detalle_terna_arbitral detalle_terna_arbitral_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.detalle_terna_arbitral
    ADD CONSTRAINT detalle_terna_arbitral_pkey PRIMARY KEY (terna_arbitral_id, tipo_terna_arbitral_id);
 \   ALTER TABLE ONLY public.detalle_terna_arbitral DROP CONSTRAINT detalle_terna_arbitral_pkey;
       public            postgres    false    243    243            �           2606    25841 $   dimension_campo dimension_campo_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.dimension_campo
    ADD CONSTRAINT dimension_campo_pkey PRIMARY KEY (dimension_id);
 N   ALTER TABLE ONLY public.dimension_campo DROP CONSTRAINT dimension_campo_pkey;
       public            postgres    false    244            �           2606    25843 #   equipo equipo_cuerpo_tecnico_id_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_cuerpo_tecnico_id_key UNIQUE (cuerpo_tecnico_id);
 M   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_cuerpo_tecnico_id_key;
       public            postgres    false    246            �           2606    25845    equipo equipo_nombre_corto_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_nombre_corto_key UNIQUE (nombre_corto);
 H   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_nombre_corto_key;
       public            postgres    false    246            �           2606    25847     equipo equipo_nombre_oficial_key 
   CONSTRAINT     e   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_nombre_oficial_key UNIQUE (nombre_oficial);
 J   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_nombre_oficial_key;
       public            postgres    false    246            �           2606    25849    equipo equipo_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (equipo_id);
 <   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_pkey;
       public            postgres    false    246            �           2606    25851 "   estadio estadio_nombre_oficial_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.estadio
    ADD CONSTRAINT estadio_nombre_oficial_key UNIQUE (nombre_oficial);
 L   ALTER TABLE ONLY public.estadio DROP CONSTRAINT estadio_nombre_oficial_key;
       public            postgres    false    248            �           2606    25853    estadio estadio_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.estadio
    ADD CONSTRAINT estadio_pkey PRIMARY KEY (estadio_id);
 >   ALTER TABLE ONLY public.estadio DROP CONSTRAINT estadio_pkey;
       public            postgres    false    248            �           2606    25855 +   etapa_fixture etapa_fixture_descripcion_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.etapa_fixture
    ADD CONSTRAINT etapa_fixture_descripcion_key UNIQUE (descripcion);
 U   ALTER TABLE ONLY public.etapa_fixture DROP CONSTRAINT etapa_fixture_descripcion_key;
       public            postgres    false    250            �           2606    25857     etapa_fixture etapa_fixture_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.etapa_fixture
    ADD CONSTRAINT etapa_fixture_pkey PRIMARY KEY (etapa_fixture_id);
 J   ALTER TABLE ONLY public.etapa_fixture DROP CONSTRAINT etapa_fixture_pkey;
       public            postgres    false    250            �           2606    25859    evento evento_nombre_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT evento_nombre_key UNIQUE (nombre);
 B   ALTER TABLE ONLY public.evento DROP CONSTRAINT evento_nombre_key;
       public            postgres    false    252            �           2606    25861    evento evento_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.evento
    ADD CONSTRAINT evento_pkey PRIMARY KEY (evento_id);
 <   ALTER TABLE ONLY public.evento DROP CONSTRAINT evento_pkey;
       public            postgres    false    252            �           2606    25863    fixture fixture_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.fixture
    ADD CONSTRAINT fixture_pkey PRIMARY KEY (fixture_id);
 >   ALTER TABLE ONLY public.fixture DROP CONSTRAINT fixture_pkey;
       public            postgres    false    254            �           2606    25865 1   formacion_equipo formacion_equipo_descripcion_key 
   CONSTRAINT     s   ALTER TABLE ONLY public.formacion_equipo
    ADD CONSTRAINT formacion_equipo_descripcion_key UNIQUE (descripcion);
 [   ALTER TABLE ONLY public.formacion_equipo DROP CONSTRAINT formacion_equipo_descripcion_key;
       public            postgres    false    256            �           2606    25867 &   formacion_equipo formacion_equipo_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.formacion_equipo
    ADD CONSTRAINT formacion_equipo_pkey PRIMARY KEY (formacion_id);
 P   ALTER TABLE ONLY public.formacion_equipo DROP CONSTRAINT formacion_equipo_pkey;
       public            postgres    false    256            �           2606    25869 )   futbolista futbolista_numero_camiseta_key 
   CONSTRAINT     o   ALTER TABLE ONLY public.futbolista
    ADD CONSTRAINT futbolista_numero_camiseta_key UNIQUE (numero_camiseta);
 S   ALTER TABLE ONLY public.futbolista DROP CONSTRAINT futbolista_numero_camiseta_key;
       public            postgres    false    258            �           2606    25871 4   futbolista futbolista_numero_documento_identidad_key 
   CONSTRAINT     �   ALTER TABLE ONLY public.futbolista
    ADD CONSTRAINT futbolista_numero_documento_identidad_key UNIQUE (numero_documento_identidad);
 ^   ALTER TABLE ONLY public.futbolista DROP CONSTRAINT futbolista_numero_documento_identidad_key;
       public            postgres    false    258            �           2606    25873    futbolista futbolista_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.futbolista
    ADD CONSTRAINT futbolista_pkey PRIMARY KEY (futbolista_id);
 D   ALTER TABLE ONLY public.futbolista DROP CONSTRAINT futbolista_pkey;
       public            postgres    false    258            �           2606    25875    grupo grupo_abreviatura_key 
   CONSTRAINT     ]   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_abreviatura_key UNIQUE (abreviatura);
 E   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_abreviatura_key;
       public            postgres    false    260            �           2606    25877    grupo grupo_nombre_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_nombre_key UNIQUE (nombre);
 @   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_nombre_key;
       public            postgres    false    260            �           2606    25879    grupo grupo_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (grupo_id);
 :   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_pkey;
       public            postgres    false    260            �           2606    25881 *   incidencia_partido incidencia_partido_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT incidencia_partido_pkey PRIMARY KEY (evento_id, partido_id, futbolista_id, instancia_partido_id, minuto, equipo_id);
 T   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT incidencia_partido_pkey;
       public            postgres    false    262    262    262    262    262    262            �           2606    25883 (   instancia_partido instancia_partido_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.instancia_partido
    ADD CONSTRAINT instancia_partido_pkey PRIMARY KEY (instancia_partido_id);
 R   ALTER TABLE ONLY public.instancia_partido DROP CONSTRAINT instancia_partido_pkey;
       public            postgres    false    263            �           2606    25885    jornada jornada_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.jornada
    ADD CONSTRAINT jornada_pkey PRIMARY KEY (jornada_id);
 >   ALTER TABLE ONLY public.jornada DROP CONSTRAINT jornada_pkey;
       public            postgres    false    265            �           2606    25887    pais pais_codigo_iso_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_codigo_iso_key UNIQUE (codigo_iso);
 B   ALTER TABLE ONLY public.pais DROP CONSTRAINT pais_codigo_iso_key;
       public            postgres    false    267            �           2606    25889    pais pais_nombre_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_nombre_key UNIQUE (nombre);
 >   ALTER TABLE ONLY public.pais DROP CONSTRAINT pais_nombre_key;
       public            postgres    false    267            �           2606    25891    pais pais_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pais
    ADD CONSTRAINT pais_pkey PRIMARY KEY (pais_id);
 8   ALTER TABLE ONLY public.pais DROP CONSTRAINT pais_pkey;
       public            postgres    false    267            �           2606    25893    partido partido_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (partido_id);
 >   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_pkey;
       public            postgres    false    269            �           2606    25895    permiso permiso_descripcion_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_descripcion_key UNIQUE (descripcion);
 I   ALTER TABLE ONLY public.permiso DROP CONSTRAINT permiso_descripcion_key;
       public            postgres    false    271            �           2606    25897    permiso permiso_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (permiso_id);
 >   ALTER TABLE ONLY public.permiso DROP CONSTRAINT permiso_pkey;
       public            postgres    false    271            �           2606    25899 ,   posicion posicion_futbolista_abreviatura_key 
   CONSTRAINT     n   ALTER TABLE ONLY public.posicion
    ADD CONSTRAINT posicion_futbolista_abreviatura_key UNIQUE (abreviatura);
 V   ALTER TABLE ONLY public.posicion DROP CONSTRAINT posicion_futbolista_abreviatura_key;
       public            postgres    false    273            �           2606    25901 ,   posicion posicion_futbolista_descripcion_key 
   CONSTRAINT     n   ALTER TABLE ONLY public.posicion
    ADD CONSTRAINT posicion_futbolista_descripcion_key UNIQUE (descripcion);
 V   ALTER TABLE ONLY public.posicion DROP CONSTRAINT posicion_futbolista_descripcion_key;
       public            postgres    false    273            �           2606    25903 !   posicion posicion_futbolista_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.posicion
    ADD CONSTRAINT posicion_futbolista_pkey PRIMARY KEY (posicion_id);
 K   ALTER TABLE ONLY public.posicion DROP CONSTRAINT posicion_futbolista_pkey;
       public            postgres    false    273            �           2606    25905    profesional profesional_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.profesional
    ADD CONSTRAINT profesional_pkey PRIMARY KEY (profesional_id);
 F   ALTER TABLE ONLY public.profesional DROP CONSTRAINT profesional_pkey;
       public            postgres    false    275            �           2606    25907    rol rol_nombre_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_nombre_key UNIQUE (nombre);
 <   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_nombre_key;
       public            postgres    false    277            �           2606    25909    rol_permiso rol_permiso_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT rol_permiso_pkey PRIMARY KEY (rol_id, permiso_id);
 F   ALTER TABLE ONLY public.rol_permiso DROP CONSTRAINT rol_permiso_pkey;
       public            postgres    false    278    278            �           2606    25911    rol rol_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (rol_id);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public            postgres    false    277            �           2606    25913 "   terna_arbitral terna_arbitral_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.terna_arbitral
    ADD CONSTRAINT terna_arbitral_pkey PRIMARY KEY (terna_arbitral_id);
 L   ALTER TABLE ONLY public.terna_arbitral DROP CONSTRAINT terna_arbitral_pkey;
       public            postgres    false    280            �           2606    25915 A   tipo_documento_identidad tipo_documento_identidad_abreviatura_key 
   CONSTRAINT     �   ALTER TABLE ONLY public.tipo_documento_identidad
    ADD CONSTRAINT tipo_documento_identidad_abreviatura_key UNIQUE (abreviatura);
 k   ALTER TABLE ONLY public.tipo_documento_identidad DROP CONSTRAINT tipo_documento_identidad_abreviatura_key;
       public            postgres    false    282            �           2606    25917 G   tipo_documento_identidad tipo_documento_identidad_descripcion_larga_key 
   CONSTRAINT     �   ALTER TABLE ONLY public.tipo_documento_identidad
    ADD CONSTRAINT tipo_documento_identidad_descripcion_larga_key UNIQUE (descripcion_larga);
 q   ALTER TABLE ONLY public.tipo_documento_identidad DROP CONSTRAINT tipo_documento_identidad_descripcion_larga_key;
       public            postgres    false    282            �           2606    25919 6   tipo_documento_identidad tipo_documento_identidad_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.tipo_documento_identidad
    ADD CONSTRAINT tipo_documento_identidad_pkey PRIMARY KEY (tipo_doc_identidad_id);
 `   ALTER TABLE ONLY public.tipo_documento_identidad DROP CONSTRAINT tipo_documento_identidad_pkey;
       public            postgres    false    282            �           2606    25921    tipo_jugador tipo_jugador_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.tipo_jugador
    ADD CONSTRAINT tipo_jugador_pkey PRIMARY KEY (tipo_jugador_id);
 H   ALTER TABLE ONLY public.tipo_jugador DROP CONSTRAINT tipo_jugador_pkey;
       public            postgres    false    284            �           2606    25923 #   tipo_jugador tipo_jugador_sigla_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.tipo_jugador
    ADD CONSTRAINT tipo_jugador_sigla_key UNIQUE (sigla);
 M   ALTER TABLE ONLY public.tipo_jugador DROP CONSTRAINT tipo_jugador_sigla_key;
       public            postgres    false    284            �           2606    25925 1   tipo_profesional tipo_profesional_abreviatura_key 
   CONSTRAINT     s   ALTER TABLE ONLY public.tipo_profesional
    ADD CONSTRAINT tipo_profesional_abreviatura_key UNIQUE (abreviatura);
 [   ALTER TABLE ONLY public.tipo_profesional DROP CONSTRAINT tipo_profesional_abreviatura_key;
       public            postgres    false    286            �           2606    25927 ,   tipo_profesional tipo_profesional_nombre_key 
   CONSTRAINT     i   ALTER TABLE ONLY public.tipo_profesional
    ADD CONSTRAINT tipo_profesional_nombre_key UNIQUE (nombre);
 V   ALTER TABLE ONLY public.tipo_profesional DROP CONSTRAINT tipo_profesional_nombre_key;
       public            postgres    false    286            �           2606    25929 &   tipo_profesional tipo_profesional_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.tipo_profesional
    ADD CONSTRAINT tipo_profesional_pkey PRIMARY KEY (tipo_profesional_id);
 P   ALTER TABLE ONLY public.tipo_profesional DROP CONSTRAINT tipo_profesional_pkey;
       public            postgres    false    286            �           2606    25931 ,   tipo_terna_arbitral tipo_terna_arbitral_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.tipo_terna_arbitral
    ADD CONSTRAINT tipo_terna_arbitral_pkey PRIMARY KEY (tipo_terna_arbitral_id);
 V   ALTER TABLE ONLY public.tipo_terna_arbitral DROP CONSTRAINT tipo_terna_arbitral_pkey;
       public            postgres    false    288            �           2606    25933 '   usuario usuario_documento_identidad_key 
   CONSTRAINT     q   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_documento_identidad_key UNIQUE (documento_identidad);
 Q   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_documento_identidad_key;
       public            postgres    false    290            �           2606    25935    usuario usuario_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id, rol_id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    290    290            �           2606    26379 #   cuerpo_tecnico fk_profesion_cuerpot    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuerpo_tecnico
    ADD CONSTRAINT fk_profesion_cuerpot FOREIGN KEY (profesional_id, tipo_profesional_id) REFERENCES public.detalle_profesional(profesional_id, tipo_profesional_id);
 M   ALTER TABLE ONLY public.cuerpo_tecnico DROP CONSTRAINT fk_profesion_cuerpot;
       public          postgres    false    242    3467    229    229    242            �           2606    25936    alineacion fkalineacion132061    FK CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT fkalineacion132061 FOREIGN KEY (posicion_id) REFERENCES public.posicion(posicion_id);
 G   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT fkalineacion132061;
       public          postgres    false    214    3533    273            �           2606    25941    alineacion fkalineacion267279    FK CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT fkalineacion267279 FOREIGN KEY (tipo_jugador_id) REFERENCES public.tipo_jugador(tipo_jugador_id);
 G   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT fkalineacion267279;
       public          postgres    false    3551    284    214            �           2606    25946    alineacion fkalineacion627379    FK CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT fkalineacion627379 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 G   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT fkalineacion627379;
       public          postgres    false    214    3479    246            �           2606    25951    alineacion fkalineacion632456    FK CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT fkalineacion632456 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 G   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT fkalineacion632456;
       public          postgres    false    3503    258    214            �           2606    25956    alineacion fkalineacion685107    FK CONSTRAINT     �   ALTER TABLE ONLY public.alineacion
    ADD CONSTRAINT fkalineacion685107 FOREIGN KEY (partido_id) REFERENCES public.partido(partido_id);
 G   ALTER TABLE ONLY public.alineacion DROP CONSTRAINT fkalineacion685107;
       public          postgres    false    214    3523    269            �           2606    25961    arbitro fkarbitro125293    FK CONSTRAINT     z   ALTER TABLE ONLY public.arbitro
    ADD CONSTRAINT fkarbitro125293 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 A   ALTER TABLE ONLY public.arbitro DROP CONSTRAINT fkarbitro125293;
       public          postgres    false    215    3521    267            �           2606    25966 $   categoria_arbitro fkcategoria_284007    FK CONSTRAINT     �   ALTER TABLE ONLY public.categoria_arbitro
    ADD CONSTRAINT fkcategoria_284007 FOREIGN KEY (tipo_terna_arbitral_id) REFERENCES public.tipo_terna_arbitral(tipo_terna_arbitral_id);
 N   ALTER TABLE ONLY public.categoria_arbitro DROP CONSTRAINT fkcategoria_284007;
       public          postgres    false    288    217    3561            �           2606    25971    ciudad fkciudad48565    FK CONSTRAINT     w   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT fkciudad48565 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 >   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT fkciudad48565;
       public          postgres    false    3521    219    267            �           2606    25976    competencia fkcompetenci953878    FK CONSTRAINT     �   ALTER TABLE ONLY public.competencia
    ADD CONSTRAINT fkcompetenci953878 FOREIGN KEY (fixture_id) REFERENCES public.fixture(fixture_id);
 H   ALTER TABLE ONLY public.competencia DROP CONSTRAINT fkcompetenci953878;
       public          postgres    false    3493    221    254            �           2606    25981 "   contrato_futbol fkcontrato_f115970    FK CONSTRAINT     �   ALTER TABLE ONLY public.contrato_futbol
    ADD CONSTRAINT fkcontrato_f115970 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 L   ALTER TABLE ONLY public.contrato_futbol DROP CONSTRAINT fkcontrato_f115970;
       public          postgres    false    3503    227    258            �           2606    25986 1   detalle_arbitro_terna_arbitral fkdetalle_ar264322    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral
    ADD CONSTRAINT fkdetalle_ar264322 FOREIGN KEY (categoria_arbitro_id) REFERENCES public.categoria_arbitro(categoria_arbitro_id);
 [   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral DROP CONSTRAINT fkdetalle_ar264322;
       public          postgres    false    3421    231    217            �           2606    25991 1   detalle_arbitro_terna_arbitral fkdetalle_ar383273    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral
    ADD CONSTRAINT fkdetalle_ar383273 FOREIGN KEY (arbitro_id) REFERENCES public.arbitro(arbitro_id);
 [   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral DROP CONSTRAINT fkdetalle_ar383273;
       public          postgres    false    3419    231    215            �           2606    25996 1   detalle_arbitro_terna_arbitral fkdetalle_ar395904    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral
    ADD CONSTRAINT fkdetalle_ar395904 FOREIGN KEY (terna_arbitral_id) REFERENCES public.terna_arbitral(terna_arbitral_id);
 [   ALTER TABLE ONLY public.detalle_arbitro_terna_arbitral DROP CONSTRAINT fkdetalle_ar395904;
       public          postgres    false    3543    231    280            �           2606    26001 ,   detalle_categoria_arbitro fkdetalle_ca191169    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_categoria_arbitro
    ADD CONSTRAINT fkdetalle_ca191169 FOREIGN KEY (categoria_arbitro_id) REFERENCES public.categoria_arbitro(categoria_arbitro_id);
 V   ALTER TABLE ONLY public.detalle_categoria_arbitro DROP CONSTRAINT fkdetalle_ca191169;
       public          postgres    false    3421    232    217            �           2606    26006 ,   detalle_categoria_arbitro fkdetalle_ca927781    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_categoria_arbitro
    ADD CONSTRAINT fkdetalle_ca927781 FOREIGN KEY (arbitro_id) REFERENCES public.arbitro(arbitro_id);
 V   ALTER TABLE ONLY public.detalle_categoria_arbitro DROP CONSTRAINT fkdetalle_ca927781;
       public          postgres    false    3419    232    215                        2606    26011 ,   detalle_competencia_grupo fkdetalle_co251202    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_grupo
    ADD CONSTRAINT fkdetalle_co251202 FOREIGN KEY (competencia_id) REFERENCES public.competencia(competencia_id);
 V   ALTER TABLE ONLY public.detalle_competencia_grupo DROP CONSTRAINT fkdetalle_co251202;
       public          postgres    false    221    3427    234            �           2606    26016 -   detalle_competencia_equipo fkdetalle_co596495    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_equipo
    ADD CONSTRAINT fkdetalle_co596495 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 W   ALTER TABLE ONLY public.detalle_competencia_equipo DROP CONSTRAINT fkdetalle_co596495;
       public          postgres    false    233    3479    246                       2606    26021 ,   detalle_competencia_grupo fkdetalle_co625598    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_grupo
    ADD CONSTRAINT fkdetalle_co625598 FOREIGN KEY (grupo_id) REFERENCES public.grupo(grupo_id);
 V   ALTER TABLE ONLY public.detalle_competencia_grupo DROP CONSTRAINT fkdetalle_co625598;
       public          postgres    false    260    234    3509            �           2606    26026 -   detalle_competencia_equipo fkdetalle_co682503    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_competencia_equipo
    ADD CONSTRAINT fkdetalle_co682503 FOREIGN KEY (competencia_id) REFERENCES public.competencia(competencia_id);
 W   ALTER TABLE ONLY public.detalle_competencia_equipo DROP CONSTRAINT fkdetalle_co682503;
       public          postgres    false    3427    233    221                       2606    26046 ,   detalle_equipo_futbolista fkdetalle_eq157343    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo_futbolista
    ADD CONSTRAINT fkdetalle_eq157343 FOREIGN KEY (competencia_id) REFERENCES public.competencia(competencia_id);
 V   ALTER TABLE ONLY public.detalle_equipo_futbolista DROP CONSTRAINT fkdetalle_eq157343;
       public          postgres    false    3427    236    221                       2606    26051 !   detalle_equipo fkdetalle_eq192857    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo
    ADD CONSTRAINT fkdetalle_eq192857 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 K   ALTER TABLE ONLY public.detalle_equipo DROP CONSTRAINT fkdetalle_eq192857;
       public          postgres    false    3479    235    246                       2606    26056 !   detalle_equipo fkdetalle_eq302461    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo
    ADD CONSTRAINT fkdetalle_eq302461 FOREIGN KEY (posicion_id) REFERENCES public.posicion(posicion_id);
 K   ALTER TABLE ONLY public.detalle_equipo DROP CONSTRAINT fkdetalle_eq302461;
       public          postgres    false    235    3533    273                       2606    26061 ,   detalle_equipo_futbolista fkdetalle_eq535248    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo_futbolista
    ADD CONSTRAINT fkdetalle_eq535248 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 V   ALTER TABLE ONLY public.detalle_equipo_futbolista DROP CONSTRAINT fkdetalle_eq535248;
       public          postgres    false    236    3479    246                       2606    26066     detalle_equipo fkdetalle_eq66979    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo
    ADD CONSTRAINT fkdetalle_eq66979 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 J   ALTER TABLE ONLY public.detalle_equipo DROP CONSTRAINT fkdetalle_eq66979;
       public          postgres    false    258    235    3503                       2606    26071 ,   detalle_equipo_futbolista fkdetalle_eq724587    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_equipo_futbolista
    ADD CONSTRAINT fkdetalle_eq724587 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 V   ALTER TABLE ONLY public.detalle_equipo_futbolista DROP CONSTRAINT fkdetalle_eq724587;
       public          postgres    false    3503    236    258                       2606    26076     detalle_grupo fkdetalle_gr469623    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_grupo
    ADD CONSTRAINT fkdetalle_gr469623 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 J   ALTER TABLE ONLY public.detalle_grupo DROP CONSTRAINT fkdetalle_gr469623;
       public          postgres    false    3479    237    246            	           2606    26081     detalle_grupo fkdetalle_gr871821    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_grupo
    ADD CONSTRAINT fkdetalle_gr871821 FOREIGN KEY (grupo_id) REFERENCES public.grupo(grupo_id);
 J   ALTER TABLE ONLY public.detalle_grupo DROP CONSTRAINT fkdetalle_gr871821;
       public          postgres    false    3509    260    237            
           2606    26086 3   detalle_organizacion_competencia fkdetalle_or277235    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_organizacion_competencia
    ADD CONSTRAINT fkdetalle_or277235 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 ]   ALTER TABLE ONLY public.detalle_organizacion_competencia DROP CONSTRAINT fkdetalle_or277235;
       public          postgres    false    267    3521    238                       2606    26091 3   detalle_organizacion_competencia fkdetalle_or382342    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_organizacion_competencia
    ADD CONSTRAINT fkdetalle_or382342 FOREIGN KEY (competencia_id) REFERENCES public.competencia(competencia_id);
 ]   ALTER TABLE ONLY public.detalle_organizacion_competencia DROP CONSTRAINT fkdetalle_or382342;
       public          postgres    false    3427    238    221                       2606    26096 "   detalle_partido fkdetalle_pa120127    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_partido
    ADD CONSTRAINT fkdetalle_pa120127 FOREIGN KEY (partido_id) REFERENCES public.partido(partido_id);
 L   ALTER TABLE ONLY public.detalle_partido DROP CONSTRAINT fkdetalle_pa120127;
       public          postgres    false    269    240    3523                       2606    26101 *   detalle_pais_futbolista fkdetalle_pa170141    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_pais_futbolista
    ADD CONSTRAINT fkdetalle_pa170141 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 T   ALTER TABLE ONLY public.detalle_pais_futbolista DROP CONSTRAINT fkdetalle_pa170141;
       public          postgres    false    258    3503    239                       2606    26106 "   detalle_partido fkdetalle_pa205430    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_partido
    ADD CONSTRAINT fkdetalle_pa205430 FOREIGN KEY (formacion_id) REFERENCES public.formacion_equipo(formacion_id);
 L   ALTER TABLE ONLY public.detalle_partido DROP CONSTRAINT fkdetalle_pa205430;
       public          postgres    false    3497    240    256                       2606    26111 !   detalle_partido fkdetalle_pa62399    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_partido
    ADD CONSTRAINT fkdetalle_pa62399 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 K   ALTER TABLE ONLY public.detalle_partido DROP CONSTRAINT fkdetalle_pa62399;
       public          postgres    false    240    246    3479                       2606    26116 *   detalle_pais_futbolista fkdetalle_pa708003    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_pais_futbolista
    ADD CONSTRAINT fkdetalle_pa708003 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 T   ALTER TABLE ONLY public.detalle_pais_futbolista DROP CONSTRAINT fkdetalle_pa708003;
       public          postgres    false    3521    267    239                       2606    26121 -   detalle_posicion_futbolista fkdetalle_po83180    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_posicion_futbolista
    ADD CONSTRAINT fkdetalle_po83180 FOREIGN KEY (posicion_id) REFERENCES public.posicion(posicion_id);
 W   ALTER TABLE ONLY public.detalle_posicion_futbolista DROP CONSTRAINT fkdetalle_po83180;
       public          postgres    false    241    3533    273                       2606    26126 .   detalle_posicion_futbolista fkdetalle_po847697    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_posicion_futbolista
    ADD CONSTRAINT fkdetalle_po847697 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 X   ALTER TABLE ONLY public.detalle_posicion_futbolista DROP CONSTRAINT fkdetalle_po847697;
       public          postgres    false    241    3503    258                       2606    26131 &   detalle_profesional fkdetalle_pr520572    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_profesional
    ADD CONSTRAINT fkdetalle_pr520572 FOREIGN KEY (tipo_profesional_id) REFERENCES public.tipo_profesional(tipo_profesional_id);
 P   ALTER TABLE ONLY public.detalle_profesional DROP CONSTRAINT fkdetalle_pr520572;
       public          postgres    false    242    286    3559                       2606    26136 &   detalle_profesional fkdetalle_pr877776    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_profesional
    ADD CONSTRAINT fkdetalle_pr877776 FOREIGN KEY (profesional_id) REFERENCES public.profesional(profesional_id);
 P   ALTER TABLE ONLY public.detalle_profesional DROP CONSTRAINT fkdetalle_pr877776;
       public          postgres    false    242    275    3535                       2606    26141 )   detalle_terna_arbitral fkdetalle_te233307    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_terna_arbitral
    ADD CONSTRAINT fkdetalle_te233307 FOREIGN KEY (tipo_terna_arbitral_id) REFERENCES public.tipo_terna_arbitral(tipo_terna_arbitral_id);
 S   ALTER TABLE ONLY public.detalle_terna_arbitral DROP CONSTRAINT fkdetalle_te233307;
       public          postgres    false    3561    243    288                       2606    26146 )   detalle_terna_arbitral fkdetalle_te963211    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_terna_arbitral
    ADD CONSTRAINT fkdetalle_te963211 FOREIGN KEY (terna_arbitral_id) REFERENCES public.terna_arbitral(terna_arbitral_id);
 S   ALTER TABLE ONLY public.detalle_terna_arbitral DROP CONSTRAINT fkdetalle_te963211;
       public          postgres    false    280    243    3543                       2606    26151    equipo fkequipo552137    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fkequipo552137 FOREIGN KEY (cuerpo_tecnico_id) REFERENCES public.cuerpo_tecnico(cuerpo_tecnico_id);
 ?   ALTER TABLE ONLY public.equipo DROP CONSTRAINT fkequipo552137;
       public          postgres    false    229    246    3443                       2606    26156    equipo fkequipo700380    FK CONSTRAINT     x   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fkequipo700380 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 ?   ALTER TABLE ONLY public.equipo DROP CONSTRAINT fkequipo700380;
       public          postgres    false    267    3521    246                       2606    26161    equipo fkequipo958000    FK CONSTRAINT     �   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT fkequipo958000 FOREIGN KEY (confederacion_id) REFERENCES public.confederacion_futbol(confederacion_id);
 ?   ALTER TABLE ONLY public.equipo DROP CONSTRAINT fkequipo958000;
       public          postgres    false    223    3433    246                       2606    26166    estadio fkestadio897200    FK CONSTRAINT     �   ALTER TABLE ONLY public.estadio
    ADD CONSTRAINT fkestadio897200 FOREIGN KEY (ciudad_id) REFERENCES public.ciudad(ciudad_id);
 A   ALTER TABLE ONLY public.estadio DROP CONSTRAINT fkestadio897200;
       public          postgres    false    219    248    3423                       2606    26171    estadio fkestadio970653    FK CONSTRAINT     �   ALTER TABLE ONLY public.estadio
    ADD CONSTRAINT fkestadio970653 FOREIGN KEY (dimension_id) REFERENCES public.dimension_campo(dimension_id);
 A   ALTER TABLE ONLY public.estadio DROP CONSTRAINT fkestadio970653;
       public          postgres    false    3471    248    244                       2606    26176     etapa_fixture fketapa_fixt745339    FK CONSTRAINT     �   ALTER TABLE ONLY public.etapa_fixture
    ADD CONSTRAINT fketapa_fixt745339 FOREIGN KEY (fixture_id) REFERENCES public.fixture(fixture_id);
 J   ALTER TABLE ONLY public.etapa_fixture DROP CONSTRAINT fketapa_fixt745339;
       public          postgres    false    250    254    3493                       2606    26181    futbolista fkfutbolista763235    FK CONSTRAINT     �   ALTER TABLE ONLY public.futbolista
    ADD CONSTRAINT fkfutbolista763235 FOREIGN KEY (tipo_doc_identidad_id) REFERENCES public.tipo_documento_identidad(tipo_doc_identidad_id);
 G   ALTER TABLE ONLY public.futbolista DROP CONSTRAINT fkfutbolista763235;
       public          postgres    false    282    3549    258                       2606    26186 %   incidencia_partido fkincidencia144053    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT fkincidencia144053 FOREIGN KEY (partido_id) REFERENCES public.partido(partido_id);
 O   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT fkincidencia144053;
       public          postgres    false    3523    269    262                       2606    26191 %   incidencia_partido fkincidencia201781    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT fkincidencia201781 FOREIGN KEY (equipo_id) REFERENCES public.equipo(equipo_id);
 O   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT fkincidencia201781;
       public          postgres    false    246    3479    262                        2606    26196 %   incidencia_partido fkincidencia509973    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT fkincidencia509973 FOREIGN KEY (futbolista_id) REFERENCES public.futbolista(futbolista_id);
 O   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT fkincidencia509973;
       public          postgres    false    3503    262    258            !           2606    26201 %   incidencia_partido fkincidencia513431    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT fkincidencia513431 FOREIGN KEY (evento_id) REFERENCES public.evento(evento_id);
 O   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT fkincidencia513431;
       public          postgres    false    252    3491    262            "           2606    26206 %   incidencia_partido fkincidencia670866    FK CONSTRAINT     �   ALTER TABLE ONLY public.incidencia_partido
    ADD CONSTRAINT fkincidencia670866 FOREIGN KEY (instancia_partido_id) REFERENCES public.instancia_partido(instancia_partido_id);
 O   ALTER TABLE ONLY public.incidencia_partido DROP CONSTRAINT fkincidencia670866;
       public          postgres    false    262    3513    263            #           2606    26211    pais fkpais356097    FK CONSTRAINT     �   ALTER TABLE ONLY public.pais
    ADD CONSTRAINT fkpais356097 FOREIGN KEY (continente_id) REFERENCES public.continente(continente_id);
 ;   ALTER TABLE ONLY public.pais DROP CONSTRAINT fkpais356097;
       public          postgres    false    3439    267    225            $           2606    26216    partido fkpartido168459    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkpartido168459 FOREIGN KEY (terna_arbitral_id) REFERENCES public.terna_arbitral(terna_arbitral_id);
 A   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkpartido168459;
       public          postgres    false    3543    269    280            %           2606    26221    partido fkpartido382402    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkpartido382402 FOREIGN KEY (jornada_id) REFERENCES public.jornada(jornada_id);
 A   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkpartido382402;
       public          postgres    false    269    265    3515            &           2606    26226    partido fkpartido72646    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkpartido72646 FOREIGN KEY (estadio_id) REFERENCES public.estadio(estadio_id);
 @   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkpartido72646;
       public          postgres    false    269    248    3483            '           2606    26231    partido fkpartido745948    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkpartido745948 FOREIGN KEY (etapa_fixture_id) REFERENCES public.etapa_fixture(etapa_fixture_id);
 A   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkpartido745948;
       public          postgres    false    269    250    3487            (           2606    26236    partido fkpartido969437    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT fkpartido969437 FOREIGN KEY (competencia_id) REFERENCES public.competencia(competencia_id);
 A   ALTER TABLE ONLY public.partido DROP CONSTRAINT fkpartido969437;
       public          postgres    false    269    221    3427            )           2606    26241    profesional fkprofesiona390165    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesional
    ADD CONSTRAINT fkprofesiona390165 FOREIGN KEY (pais_id) REFERENCES public.pais(pais_id);
 H   ALTER TABLE ONLY public.profesional DROP CONSTRAINT fkprofesiona390165;
       public          postgres    false    267    3521    275            *           2606    26246    rol_permiso fkrol_permis39796    FK CONSTRAINT     �   ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT fkrol_permis39796 FOREIGN KEY (permiso_id) REFERENCES public.permiso(permiso_id);
 G   ALTER TABLE ONLY public.rol_permiso DROP CONSTRAINT fkrol_permis39796;
       public          postgres    false    278    271    3527            +           2606    26251    rol_permiso fkrol_permis415011    FK CONSTRAINT     ~   ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT fkrol_permis415011 FOREIGN KEY (rol_id) REFERENCES public.rol(rol_id);
 H   ALTER TABLE ONLY public.rol_permiso DROP CONSTRAINT fkrol_permis415011;
       public          postgres    false    3539    277    278            ,           2606    26256    usuario fkusuario624350    FK CONSTRAINT     w   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fkusuario624350 FOREIGN KEY (rol_id) REFERENCES public.rol(rol_id);
 A   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fkusuario624350;
       public          postgres    false    3539    277    290            �   0   x�3�4�@.i�`�1�Y& f��0�e�`�9�Y`�=... �.	�      �   �   x�-�A� ���
^P	H���B�\q����|�D�qG�Z{Ti���U�Xt�5*f�@�j'�fR�/C��E��C��f�Z�O	��y����E���N��^r,������%�+��zص�'�wx���$=      �   {   x�e�1�0��>�O��P���B�B���2����H�"�����lo�i���"'`���^�Ein�I(mk�9��g�rky*��;�:�!�u�|�V���
\c5�&�ü��:!�я+�      �   k   x��[
� ��]�+����P���
[R��u�33#�Dx��$��V����]Q��\o��ҙ��X�����;սF~��Đukꞩ}�[�ܱx9&9�?�      �   �   x�m�M
� F��)��e4&�v���&��2=Cw�N.VG$�2|>߇ZL��;��x|�v��Ii��Ci���Mh0%.쫣��<��k�Fa�BU��@��Z�mO!�$����u��\�������B]��ͩ06���嘼54%�[�@q��T�N��3�C�ch�hr�^ �G�T      �   �   x�m�;
�0 ��>�P
��"�!��?C!��:u�u|�6��h�@}�T��|y	`��<!���S��AGf�9��O��%�B�n�N5��Ş7�J�c���Z���*1Jy��jՋ�2�O\�#pzc��ə��uc�hH<-�bIA����pua��ao�� �)j      �   f   x�3�tt�tvQ\F����;A\W��� �@0�1��_��ƠOG��U��P�+Pȏ˔�54�?�Dq�q:{:�.sNgWG�ý� W� ���      �   '   x�3��!c ����b�Hb�P1��W� ���      �   �   x�m��	1��sRE*���d��:���lC�`;ۘ�ɂ0�]^x>�\ENє��(�h<t|d5�wz+�'�`'���7�K$AȘ� ���;H��@.@#G�@ͅa\�IB><�]Gg	��M85qY�@�C�[��z�h�?^zY�      �   !   x�3�4�4�2�F\�@҄�H�r��qqq 4Xt      �   *   x��9 0�fL�7l�G=豌5%L�i��jq�w�lJ      �   $   x�3�4�2�4bc 6�2�l#0ۜ+F��� S�f      �      x�3�4�2bc 6�=... c�      �   -   x�3�4�4�2��@҈�L�Ic.3 i�e$͸,�d� ��Z      �      x�3�4�4�2�F\1z\\\ 
      �   .   x�3�4�4@�\��FXČ���`�q�b3�"f�E�C,F��� ��      �      x�32�4�261z\\\ �      �      x�3�4�2�4����� ��      �   O   x�3�4���4����(A��\��F�a�sqa�P�	�r�q�e��Q�s���D�\1z\\\ a�08      �      x�3�4�2�4bs.NS 6����� ([      �   (   x�3�4�2�4bc.# �H��@ڌ��M�b���� f��      �      x�3�4�2�4�2�F@:F��� I�      �   3   x�3�41�U�P�4��2��@���c�if� 9&��`U��@N� [d�      �      x���I�5�y�9�\�6 3G� ��$%S���"�I�&�|���Nm��7"S�pX�ݹ��q��}�ᗿ����?�ӿ�����������?�ݟ��o���_����������˿��_��+�����?���˿����)���K�%������O�o\����_��/?�{�_��O���?�������/�x���υ��M��ӟ����/��ɧ�+�+�z!��߯��/����������?������w�?�����O���?\9�߯�Jd�\�ƕ��/������/���"p�\�W�準��}��e�����_~�g.�������������y�o.��-�^�����������/�����7���ߗ����W�R�f�����������_~�������gY���,k���Zȿ�׿�۟�����?���_��?��/���C��|�>���;ϕ�����o��;��'�������<�ϟ_���2O}Z��W���{�_������?���_��X�
'���Z|��_
���*i�'͔�Oʼ�-��>�q�w�3>�y��]���������/�o���{�������ƽ��Y��C�������w�Za�����Ϫ���sU�Fy^����|6����k�4�S�k�-=������~c���2�1��ޅ)�G�,�SY��Y�B��-����sbyf
o,_�"5��jj���F��D�>�}����<����S~>�.�|*�W]�t���F�+�~��'����<�O3��/!��Ϭ߮r?鷤�y�J��������:�)<�W�X�4��M{�Χ.�~Ś�Q6�����b
-ǧ�g�7�������j��5і��̬`;;���2"���)}?1�z|7���#��Ka�G���k�S�؟��s����Vo���|�}�����w���ǳ�UK��l��a���w�S�޳G~_��ެ�y��k,Zy�bE�3�9ae��R���������_�,_���}��k���;�����Nn|~<]yGl�V`Af��<9i�r�"��[һ�v�j�պ^V�>k���s�x��Q:��G�j6�6��c�}����v��s!�֞ٮ�������C�^뽾�J��ޕ��FE��s�T��ޯ��c��ۇ�ح��0,(:?�\6�Eqx���� -oFI�u���z߰��6Tǭ\�+�>��=�Z>�~�Hi{��F��Y<4�o�|�3�0����֚��G��R���囮�Xi�g�1������<׬���y�Ya�c���|���no���g�VG,9���5�~�Rr�l�wB+<���#`L�����xį�x�޵�Sx��N[��ق�w��;���JƎ���.$�U�� �OT�i�9B�!��<i>�%n�*i}��0U��"���r�EX���'է��f�/������5���2�X#V3et-�����H�2�����l��a"���7N�Ǭ�j_H�)���X�x2vs�Q�jn"��Ğӳ{E)��@<��E���O�(�yCc{�ZA���ʼ�L���3vO��Z���P�>+&j���O=��)uǱG�m�ؿ��b���M�
ԗ;��AXF����~?l�Z#��B}�.��v"[�mV���ͺ;^�E(��֜wB���L� Ll�<#aY��8�ѱ
vY߳�I�:v�c=���{6�{z�s6?�����T������'w^Ĩ-m	���,��<9~�0�'��~,�D���Y�;+�[��+�3��oOb}v�����*"���p�8^'�u#�i||_%#�	O�+w�pL���a�vcTX|��@��X�4�%$�*�)��G��?#2�������R���0��Ɉ�΀݈fgs�uT,��蠑��Y_|l�����`z���= A1a]��a�Tx�)Ŭ�����ڸ i8��L��փ���M��2�
���=�U���trc���B)R�X%p�:��8:���!g�,_�
��vM�X4Le��<��0�Ȩۃ{�!���� �1ċ����z��p�C�� �AA�&n�exB=��ĉ���� a�ލ�lˎ���U��+� T�^}t�k"�@�2>���9���Ҿ�t0���y���q����& ��;7{�;�y-���-|����nd ���p�W�A3{�[�-�8��`<��.��q��=X5F1���a�R�0��@EY��.��O�s#��������$w X{[,�a��H)"��}�kJTp×VU^s<��"��rp�(?����4�B^�'�"�?��Ll(��m���aS�5x�� *�1 ��	�2߈��R�{�.���s����DU��h\��\��6�� ��$
gމCe߈�"/�3���@��<�>��/�!bu�_6���*�9۽�����1hP:��!�lӎٍ��qJ��k>Y	�hC$Ve�%<Ͽ��3& ����\�C��s��
��J�\��/H������"O�)N��@��|�_;��Ha��yO-,+�
xp��� ����u��%]0v7_X�߬/����w��&Ñ��=�0�R���F=��%�oq#�v� ��g���c��Pt� �V���j�NBwpb�û&�p�f��'w�O� �w�
 �����Y�AB�� ��U�l����f//�#�Ƃ5V���!>o�GRY���h�N�rǃE�ja��`��20�w���5KQ�mp��`�ZG�]�U���T�Z�U��T��D�(WF��o���A���6]�-0���l�۶�Gێ)?���y���k�����Z�@j��gS ���^1�G��y�yh���r���� ���@ź��"��虣���2}��Iy�r̋����˪+����:J7��n|Mu5�V��M��#)~
�&�$����i�����C��t�1"<'`��c7�ˎs?�?b�����wD ;�#��	>�%_ZQ�' � :��ѯ�s��H�� �p�!�<E|�㿔҄^�O����h.�15�qOײ1Th*�8�`����w�sWى$c ^a�^��`�/j
%&�x<��mL�3'z�z��/��H��!��A����[S��o�Z�opk��#��Ъ�)<6�	�<�����fy3�@�m<\E�j��P�j��#ۘ%(�X����L�1@�a�1��}� `���)S��a�aQ0vHt�E�%��lLdO���P��i�`	�*2{~��'�9~�ߛ*]��X���	e��B-d��Q�'��4 �j�N������`? r��"��Q5�b��O.���.�=c�OE����g��ޏ���w|Z�v�Gw�rI�$H�jH�7RZpe��B����On\��!��&":�ރ���"����7�0�.X���~�����oc{�H��Ã��쀈�Ȇ�+p�&_/���zy߇����]�o����j3�1��=�U4�gn�ѻ*���*���[�,P��w����up:h��rm����{AB�	.�G�$�T��S�������|L{�,*W6�2���M�"_��%l;�F�"ڇ�'��gEq�\U�2��Z�:�������M`q���egAA�)��m̋oXv�-�O�����X�'.w\�Y�?��k��P,g�<����m̶�
,K�sldG��0���Ú`hq�uBH���DC���$��e!k�9�zKp�W��*�A�ibk�aOJ�c���˿���M�ܪ[ p�G���͋�ؤ;��D�Ō�chx���z��8���t�R�^�}�8x��`�u��+��+E�7�� l �j��;kYzEC�$��KB�!sma+?�xU�H,���/���\�v�� P����9"�a_�.���;�>B�������0�{��`!��S�5�(x� ��d|į Ϻ!K��az�gt,�1^�g���.\ I���x-�@\ \��zX3X�fÕA� ~��&:�I��rs�Zg�@�f�J, �-�q)���w��r:� > ۶    ����Ș�ڱ�.P� ��!6�X�S�;\���~+Tx�T�f�l����!�ǃӆ�p�]�!"�pXP>v֠�j���j5N�汐��?�~(���[��W��B	J��1?Q�NVM���@�PGѫ}�
2d��B����:���X���l2��2�J�=����=?�V����� ���~��w�V�͂#̈	ϊϩ��!J+a�>x�i(jCragx��j�?[ԛޅ�(���7�a;�za�A�M&�`�40K�H�� �xJ^{��F��90쇔�`ĥ�a����GY�XT����:����;�<��O��������"D�� J��Ώ��?ߎJ��H��t�L:�c��k/a�/��N8�7j�����7&�N��{�l��N�~A%��xaђix����=lR�� ������u(���Y'�/�����1��E£K�N�w��@_�k��(S� �06N�k�R-�oBi���7�����:�T�%r� ��&��59az?�Z�jL<z<җ�>��}pX`Ӈ2	{<�	��y�<Ae�wy�X)v����ŏW
0 ׶M�5����	z�d��Rx�
��(ښp~��y��� d����E�ac���=*Z�>\�m�<�����m����1��W�;bÓ�n@�ZՂ��)a�7�=y��_M��4�:�
�H�1��q�R!$;dH�
'�_I0��Χ�  ������G(�x��Ż5�OHz���3�3آ#Lm�趂�f�2�vK��`R8<�)?"�o^Ƭٱ'&��ܬ��Yx��x�qI�6��TO
�,�2)�3�:H	��h:1NV?tTq�7�x`��g>s 2�N���� �� Y*�����4�q)A��！
`� �E,��O�7�P��vh9�@�1���E�#>��F���Z<�Q�vO�����Y@,+��]j����~��]`�c�MRd�o���UPƆB���U�A�;���nҏ���`��.p�פϫ#��>6��Όj�d >@��� 8 4Ѩ�خYCf������b�h'��F�����I016j�n!�||�&a8&����x��L����5�G����M�"՛F�0�?Y�"f�sS|�z1`  &���9��tm�S$	��3��`���b�t��b����)x�.A��M�)P���6��#ڰ0�Ճ�:��t�2k����j��"A��`h�Z}�"������E#/�S1Q1�����+F�E��A���R;�uN{h_k�^	s*~�^�q�����<R����؄vs����K�>���r�`�=��|$j�P�겾�H���I_�b��7�Rn�͝�S��A�y�5�Mӛ�����Eg����u$��θ٠!�[��d�f�������lL=J�װV�(�I�l�{1�V͠wx8�p�k��'Qŭ�<'�>�X�@1ْqJ@G �\����M��w�܍2���Cf=�)�U7���Ae8�&�4A���{�@ �{p|����0�Ӷ�&��\�6��x�h��K����&��850�F�_$�OOEMq�p2�A�L£�H�LU�;c�D�C'�1�פ�E	��^���<5~
�D|�-�;���?n1Q]3����KD�Ђ�X�<r/?�V���-��,�*�:r�����A5q�L3¬�x���7���5&||x,�i�qA>(K�xv8�-Z�W�Mc/�  ���؊���ηD�K8"���)2�S��fc����➀3�q��aeg�݁c �.<��S�>/>>v U��R���` ��<��y^�t6�o�z5M�E��, �֖;�	2�6c����� ];��C�:k&�����`����_Ff ��<�zkۏY�ʖ��I�> ڹ��V���?��T2�$��rM1�_X���s�_���h������$�I�Ҩ�}0�l2�
�s��AV���lEw��}�eL��v'�|�y��}!67��_�K(A1���׉<�`P'.qkfƵ�c���*�B|#o�"�0a��&�b¾1w��l�ag������G0�1-.���Hn����t6���tB�m�<�ﺀD��uP��t�Յ�UЅ�4��x��<�[*�b����\�'̛�C�Aw��Lu���}����d>7��j�A.|A�X@>�d
�1��1,������ Җ���\j���ƣ�'�#>��ܨ�Y��`�>�^ذ2*^�5������[���z'���V0�j��dU�,w@�g����M�sB\�y�֛`�C�8$��c@b��*���P$�w��Ӿ��S�XL�5��s6(ܐ>6%�W��KK��ʄ9���-R��]�BV�p^V����h#ʇ+��L�#��ZK�=x&�ބ�����S��"#�<�0����#�M�� �c� ���!�����>�}d�m+������s���8��k�CN�ǉ�4��� ����C�p��!� ͳ�SfL �XH���P��d=���v��C�p�h���b���j�%��m����><�j16�����D����łcrٱY���,Px�c�<��AV_��#�����#���X�q���h��K��nw��S�6��|�4��݉}A(�n���4�i�6}����E�
X"��������^Q/��Z#V��DY�8��7?;0x�ܖy��F���϶�A&������\Y3�6�����}B�S�_�m��f��>���U�.8��"A��>�MT��kb5?ٷ�>s�9[���v�I�D�#c�L`����2�	��F�_�l�&�_�r+���U=�U������@�@"?#�A�s�1�;�)��0�ؼl�孆Sq�!��	�L�k{R3���9�C7�!�D��5�{��x/K����<Pݜ�}�Y�'�
`cȯ��[z��?��~�4N�Un�?���tQ���~��u��&��3���<�ĞJpFl�=��p7o/�1#���L��$��c�0�����`w��BJ��pt�3��T�������$�}
KZL}H΋�D���`���G�Ţ��MO�iBg����� n�����/h��AE!�!z�x���#D���kÊH<R�D��C��:�T�g�l� 4o�w��7��]P��H,V�d�Ĵbi���o�3���*�l��x�*��l��1���0�]�x� ����NlN�4��Ȩ��k�@8�xI�&>��3���W[z�0
�é�^�m��	N\j�n<�Ԫ59�{��HXyRM<�dw�w���X�)�'Ɵ"���"m��OVe�{W�܉�|A'*�����]�tLj����b�j�ȁ'�e	T����o�R>`�bS��:!;�2�C��0�e���t|3�'���� :��a�6�����[��|���c�geA�H�t�>2�j	>>�j'�(l,�-hX�e����~��QMq��!�
>��JU���d��g�1*S�6�,fd��Y��9���LY�XUq��*Xq<��O�`౱H�����FA}H	L̒������;���k��X�ɔ� �;o�)J�z��MFt�36����P�� NUĔ�aqE^�$�\-U h���͸0��"Xl�L����!�nЍ��/�B��@���4��H��{�Xą�1�&�4<E{�w��͸?������V�I��$��T˾D��[l�$�PbD��t6I���ns)�Y�dg�,��><0dE%��4�Z�Zʢu�3�%��%�T�$�B<4|�~t��p�֛{�Q1����& ����:�ҭ��v�Z��P�`͒z�
�J�#`�-��ϵ ��Sv`eGny�����~A.���b"�1	��A��,a1�UC@CQ����[fb'F�?H4�������v��ǋ�y>�y�r�5�    P}�"v��-hy�.�PP����4z��6���!���R.�g�H'�f!�i��_�"48&�߰v ��k��/��cm{~,f@q�lv���֌q�nC�\��93"G��M�w|,��蜅���̇��L)O�����.�HB�f��#.�Y��m2ZT1�s���M6"��œ�[Wѵ�Ő�)��w,JE�L�X�2z�`>���D^�x�`U0��:Yy�=�U0�GW���zv����N�領L��j �}?�#��@=Z��1Z�������?������?��/���w��a폿�8�����[�Z?��+�3|�ߺ���8���K��z���y���Ͽ��v[���2�W#��Y�v_��%#�H7&z�LA�����\p���O�n��Ks�}o�������^��b��<�qY�-�O��  W; /<>�qǗ=w�2�'����p���p�VL%Du& ` ����D���&��i���J�d4�)gwM�9�.��7<��7�܋�|�r���2s��O�=���*L�P�]~f�"�?�,�y�qm|>a�X����mb����0V$f�5�aU���}�k��tSg�߽r�mP���w"��+?�]������{�%�%B�,1?"�~:��w�n���A:���HVѫ�nH�7��F��k���?�0s���s�`ŉ�'h�PŠ�F3�v�,�`4����⭧��b�W�Mo:"���Ԁ�Ѽ�9����y�[#V��������)JX�_���-�ˈ)�b����:ʸ#4,jآ��ϒ�8�M��E�x���ľ��6d=X���L��M"4�^`=|��<0f�<Xh�u��Q5�. Ҁ��гM
0Q��͞�m��m��
��h'J��`��`�a��;V�5'�ҠM9ۀy����J �U?֎Wc��{�v�빡o �	|1603Z{���o
<���ѳ5��l�Lŷd���V�)7�=K��7�H�5���9���r�i�3����c��d���F��?��t	���R�[��s-(��v4�J[�EŒ{���Td�5̆�	���W��^�0sy-�ƽ]�1�
��_��n���,�?Vw���[�o�4wjD۰���o��%�T�i��Z@#xT�����*A�܅�� k�R�m#�֯������-��[�����c�P������b�y`����is�F�����s�3n��"��fh�R���b�{5�"?Ho���7�x>���ׅs/���;nPۧ�^d�Y֊�r1�'V�� ��n�eB�Aͯu�&��a�w�x� ��+�ʳ�(U*0F���P=䷯6��~��8L��=hPq���J~����JqP���6����)J�H���H|��El��Xׄp���I���W��~H|��@�%�P/4nY:�ۚq�%|va��UoY��'�cI,�	�=��ǰ��P?��n6��>�[���m��U@z�����\{�,0���y����� ��H��y�2"4�
��L��q)� a)�[�=����Y�kbݒ�x����{]�p4���y�z�| �'lmx�U�ݸa�>�049m�bY�}�Z����[h4.?+km.��DԹ�y�׆�L�Χkݹ?��V}���wL�e�����������@M���m����O����1�����j�@Π�)\�>����`��a��F�B��q����屭~X�i0�^/#��E[Î���<��L�*�n{�M�C���C���Zz�G�D��l��P�7��FW��kXҦu�k0^V���ʭ1�O��^XȺ PS�m��g�E��#�`���1� &d�$D��D����dL�#p�}�1�X��|n7�'l+Za�>�9X����g�ٷ`�� p�eAX	,�j��`Tt7f��P�2��o�GHu0^��?	�;&{����b+]{��z9Cձ8�m_�����n��a�v��ۻ;��-�Dzm���2�ha0�a�٦�pb���+�E������-���Y6r��I�q|v�L����X��W1#U�m�↚�?g!L�^���y/=6'���e��)�t����-�oż`�޲c�7��Y�s ��|�g�׎�b6h������kP��b�����g[?qN��m9�
�+�흄�k�T4Lm�vz�D�.�׃6�;�S �a06�V�c�$��Bӎ�`�ǧ�jM�|n��Q�_m\ږʂ���7QaV�0'�����'K�؃���q�5����q?,H_V�Ֆ�ې#��&���km��<�����BeS`��BR
Tl�)=�i��0���|��n$[�V�󱏟Q`�[��!b�B3�����-�T��
����;M���� ����!f��P�Zl�1D�"J�ڼ`2��&���Ft0��U�{n��c�=E�FL��JHj�/��jam3�aXÅe�6]p�M��oK�,�Ш���8l._BhaT�R�Sx8�z����a��3�'r�9X]�9�-4��|�O���aXՉ���U5�LV'͆��yY������b��o�(p�B-������b��c-c���
?���s�g�z�L��y19۴�JP�y |}}�ɖb���lk4�WV� p��j�M��BA9d�F=��L���)a�{Ƃ����1�]n���(�a@6�z��b>�d�,tL6��D�]>h���\Y!{Le!�z�)�YkK�Fo���Z�2�zY0
.�tc�ķ]͘o}�cD �@��6�K�K�y{�O�ޚ<L�Yݒ�j����k�_�jO�qh�ό4Yy�8����n�lr� O�����}n��|����N�Vv�n�0�a!G�vb��ʴ���A��>ܹ�m۱�0�!܆����x`�7�a.j�Al��V:�<q� �bC1�Īp($�d/k:���8k���y�}@BV�zC1���[b��-�Q�p؈7��
�}�ʲ���Lp�]'3ZjF�;P�}�:����gy-o��l����1�fm��gU����y�����r�yV�=9��4�@a���B|�U;�,V@W	X �N`� L�;��-��T�����ig(���K� *8�YMT'�A�٨�%b��:#�z���d[�ݘ�Xl�i�������,�xn��Tf��q8���ܷ�F�y��d*��˳�1X�هq���\3�iHnw�ԣ�4P��@�b>�u=5��MoğiXF��CIďyP���11��㳴��B5�9-8�3� Fg����v3�Z+�Jf��
�d�=�uCksO�"��< �jb_����|͋��#�A!�y���0�?eu���M��'=#�5����c��T˔�N�8$�>���ie��n�e�Ԝ̦���f��N�	`�t"�Yy;�V�r�Ѱܶ��� �8���P��y��,�����k-p���-:�"��D"� �����3F���C|l�&醚�N�%+�,S1fn��m���V����S���D��r���8��?>�����\I�.�	~��Ͳ:�E���^"�j�<m�DX19�v��Q�R��ߗ�$+[5
n;��!^j�{���5ق��q|v�+�3��G�ޜSQc�[��������-��(o�Ԛ����P7k'1��-��T���^U���l+�A�P��h��:\�$��J� �B130�h�k4�v��YHK��24�� :kĘ#?�U	Bk]x��K����:h%ٚ�4�il����#\�r�:`�W���`O�qq'`��7VPܟ}"lN�Ǌ���z@�-a���������N�-c���嵹�uV�{祀�^S�V��6��?8���J�ͅ����ZH�B9�V���:Tf �`e��2�o4����`�x@�+�B]���@��*=ౢw�`���^E��x XK0���/"p ��X9��k��$�/�L��a�el>!��DGDa�X�n��ts    \�v�A5Cj7H���czM���E1�(+Nu6Ade�5�c@�2�W
�����ܹ?#(IF�ЈZ��W�կ�
u��Z���J S�ʆ_1���W$��v�8��V��xv�巚"���kE��EU�N����3�����3l�83V-~{�ж0����T�m,x��BY���U_@����C��QV ��,N�<D�xb������΅D�,�Z���f�䞩M�c�<�$'�l��j�����6���!N�9�t���5�qGGa�UC����ڦ0ޙ -�!7(Bt�iD0.)(�( ލ��9S�%!�	��Z�̘�k�"�m�5�;O�ӏ�9Lv]N9��Yp�+��uVk���_��:I�`��۴^�����Pş��t�W7�ux>k�c���+s�c�U�1s!������c��ô�{���b���8�u5��ЈA�D�ȁ��~K��� �).��{�S�:�Eͱn�'�[�}�>H\�R�w�La��ωDl��:[lm�b��D�`��������������v�oHn<�ǂ�_�d����I����M	����%��s0j�K�|ʎ�lgs�ݦb��X��|�\<��\��Z��?f��c*��s<�T�1af�����9���)J��t�� ����/��Y�0K� ���t��O�H����!	'8 D����^�耧	\�V?OD�q���9cM�@9 �����"N���;ƻm#��U��:���.�%x�80�@�1�l,1�0f�������8j =۱,�+�!q�V��tоf�>�o���bU�y�P�XAJ���.��
���]���1��4��[ei�+H`#��\<��)��I�fs�cC��!W'2=7�
P���=�п�ϲg�.>�Z�­�0L�S��m?��{F�h&P���r����̝���R[�0���62s�vÜ����]�`��6�V���CK�`�L5��Y�������ř){[ư0en��,S���Ɵ��\˿�Oc��p��������@n�XF�pf�u}�ڠ�s�}h����Q-Q�
p��X�#��R�@,�D��� �;P��W�mH(]��a��vD��XFw΋�Bx��`��%vv[u�Rc�^��1@綾e��rK�\P��.�3p�e3w�S�pv0�'�q�/	3e+/)0�����r��e$%}��`w�� !l��6m'��Yo�c	�]��r��_�L��9����Ѹs�-�Z,d�6��7h;���N.�& �|� ���]�F��ƶ'`�����m��WR�t�V�������� Q?����N@�вXY�0�23"\��c/2�ۡC�^��"?cL�e�����0f��V'Jt́����!Vu��q�[��c�՗pS�Jf� ��茊f�0�|5�ct�N��8k�]�k��E��B�_�mlnA��_��d���?���BGw�:?��;�\c[��s��O�3w!�"�!��=
�8�aV�a����x�hȱ����,�]�Uh�E*��
=LQ�b�T��s��Sk�X��A�@�FH��L�6��m��`��A�ݛ8Ǎ:Zx�����_��[W�1~攺x�s��fc��붆 ~�)��{Z�c#����x�Q�	�5D���˕Uƒ��,ٖ1���ph�.�L�\��V.mv#�i���4�Ϲ�����4�kl�(`��gu��Yɓ�[�ց��~�Y�r�g����S`�}5��?K��O�Y�6+���@a��y=�T��=;B�_1��YP�u�E)��*���}K_1�Pt�+�y�����:- �eZ���c��3�,/�+R�����w�NA�Ӄͱ�����J 2�E��,CLÁĎ�J�n�Q�q�v7Ԍ�0��$c�-�!��Xd릶3=�����^n��\��j&���s��,U���m1��f	@4x����m�>��(7|£��/z��dz�,f���厧[z=����8b
�'Wo��{O���xn��'<�h;����ãj����h�ĖB��պh�"[m��yڻU%������ ���$$����|�ô3�;%�6�X�T��F�+w��jsx�p���Ñ�����ɹN��N��Y�`B�F�k�!���4��&�
b���И��&ls�ڜ�c-���8�u��ʲυ��Lc�)���mǲ�*A�\DSԍu�1qy�=����h(S�B��As[�h+���3�x�$����
�[���b"Z��+|"�}@wb٭���8uxh�w���T��<N(e����[B�o��'�K�H���Z��X��P��@<҈���ۊ�]S��I�z�V_�	b�`�x����"&�F��@���ē�����ʎ�bmqjx�;BO��?����0�kS�cg,guԮ=<ov͜�~X׏w؇2hV¶�3�s~n�q���������b�b�㓉�a�	�v��O5�]�ǀͳ�S|��:�[��=�A�e�X�+N[k��ya;a�c,�q�fچ��i��LG����n
7����J�i���3��\�Ax�fV$A��l�<$��<����3��_�����r�1�n.^1��lY��UE�X���ώ��N.$Ͷ�2�� L���e�vLv$�ю4nGK��^��4��"��T����֡��pw��{,�E�^D�l47O�`)xf�+O�����8Dv
+��sdF1I�̒Wg�+��������E`���=X/#��6�p��c�0+_���tǡ#!0�̪Eg���o���L�� �*�������xv����'���@�?�����
빛k�ײ��P[St@�[��cC]w�7ءv�g�E�,�UV�{K�P���k{S�[�����ݚ���W1,�Y���>�~OY���ͫLOJ�6��;t��F����8#�wȇ�O,�dX�k�>")��	 ��<�O(?ݦ�?[��&�Zuv?�:텥�.�]�e���cWɩ�b5x �e
B�d��0p���I�g��P��	� D��;��Y�S������x�kԯhw
Ra�J�DmRD'�����t��ƞfV=	�`�����1�<L��7�՚�c�ַ��3�[�aV�`}皏	���+N��v�b�`��U�<:�`���[������s~CqF��Gՠ��Np��������A�x�D� �k#`��	�8����s �t��I�rMix���)�k�ډ�����@ء�!˖����[t�'I ,s�u�9�# �F��hv�ׁd���t��U �毻Su�l�=ąNX[Z�ڧ6���2b���-��d�A�-����p3�Q��d#���t< x;�$ie���$+]�(C�f������q���{߂c2z,{��x-cz�I2.��i���O6V(iw��.@'�7W���j��?����"e'�E�4�s���14��Ǐ���3�'+����֞�1eQ��F�&���5�,Q�b^�ڵ��.��Q}x��vC|CA��u��m��77o��:i��x��d�΃=���իZc��Oǿ��`3��x�[3����^���P���ZKA�ٯs��&I�C<y?��`��qT�]CG�Q/�hs�\k��u����G�t��I��x9�L2~S�0@�T����x[q��u�u��z���y~Q&��u��d��;�����h
�>�֦�zƁ
���s5?��5^�:h��	DG耊��19U�kMd��H�Jv|?@��*RǏ4�?C"��l��a&��m~�XO������V(�[	��UVm�G�|Z�u�Bt��X" V������Բ����Up�`u0��X
C���f�����<,�5����Fb�ff���;�i;y�D	��"�����15N�ɘ5�$k���E�x8k�=�b:}�?���^|	W�^_��hp{��h�C��MZ8�Lţ��
���k0@O�A�����ڎ�0�a+F������i�-��X'.������ZN��f�vry��������2?}��    "�� tz��fq[�g��d-KїC�}`�a���t��I��㭰�֗��tT�u�]2]�0j�3�n\�i�Z��p[0�-Z ��������~����䞜$h���m��S�A|�æ�&���cQ����W+j���B�����A�� ���SW��`W��8̤c��چ�	` �;�c�J�pK�l���z0�'Y��پ�}<���h�OwJ1���M�8 L�o!�3!|���5C ̝I�DW���U��HYq�(� ��:G�Lk��s�"��{u��t�k8R��FO K�y��69�S�e�߱�r�qTd�l����eB�q�Q���%�ݾ��,��Z;�v�tW�96'����5\�x1V�E�5`�;*�}���-9{�1�m99�ެ�t�>2�������^p&=��F��3�+���E"��xH9�&	� �q�>�����y�Ô�6=
޺�j�T=��2�c �k/=��c�����Y�����AxV��b�G�S��b�|��w�\����Q=,ut%�հ|�5q�q��� i���#:��X���Xՙ�@)�U�ܒ�m�j���,�g�[ˁ�v��'�����SA|m��@�f,��L��F�1�{\Ge���;^i}�|��=��� YʎZ�����=�꽁 �;6��(����f��"���H	n��h5����t����?-��9��)z@K�(��)��1
V�o����!��;�b�����3�q=3܎�#�۶�%����l8�"Ѩ?_������+Rj�a� szM�=V��)ndE��6�gN-��(�Ԣ��S��Ʌ��8�& �V#��x)�U�&3$VJ���̷C\a�y�V�eĤ��=��c�ō��M��>U.�8fa��gP���Wn�;l^b9��S�׾�u��xڥj����\�l�V��öy�ףl�!ܶѰ�`
�yؚ�O�1)��$7\Kw��c�����V'���5�c9��a����oVX�ZX�"e���x�ds76�IKȬ�o��gEF����5+\�(����]챒���gO!�̷���;4o��u�@� �<�5TcRCK����}R��vQ2�k{�)L1�"���D���������A�a��}���z�q�<U*�#����P��쀃(ؾ��|	��#�a�\v�@p�ֶ*W����s����t���w�d�<R�9R�s��Ne�ܙ��4gM�������:f��yk�l"v��ӣ�-�qSXA[�Y�&���n<���@���`ʇg�[E��hEP&f�K�����0�;߹�Ͱ�w�Ù&���(���.��m��\m�ŷ!-!�@�"zL����l�zVO�l�]���܄��Hŉ�ihz�v77�6����>�x���s�l�3+��4A�t�+�Hz;���A���(����\7�`�L/�"�{���3P�D�^����[�lk-�D4��"dc\|b�$��Re�0򎒶�@�;��E�N�fp����G���>8��d�Z��A��xֱ��p����/U��;a3d	��լ�Wt���x����,@�n�F ��<g���j Ԁ��ƼZ�1�G�'�6���H#f�
N��	ę$��S䝚��IS}��1!�hO�i����mA�?{��'f8����@u�)�x�:&��>{v�u����#Zᚡ8(8\����S2�D�c��ﻖ�5t��h��G�Wf;f���0֭��Ӄ�9 ���M
g�5����s��l���5+��#���in�1�Zm���Y�G�aX���騄fzXꢟsy���i�(���=���|;5@�Z (B��c��=Vffp4��E,+k�K�X0q�~�y����![3T��g��Ğ�Y:m��*��G������638�w��V�Hp-�(�#a-|�;�.�b@�#6��M���H�/�qJ���s��2��<�����"�i�v�X��0>��;n��7���-��wޣ[�k�L� �Y��qO���MX�h����y������hV3 �)j~^��������_�9�|��=k�_��5�����b����tN���v���%ݲlm"���_ۣ�<Aԋ�7��1ZH�����t.�S�,����l������b�pPGT���@�Pl^K�S�ϧmL�楇gBg�	�Ny��s���l�$����	O+k�]��&�K��s�3�~N�p�ygk޳:��NG�WS�?��AӰOw<hq����6w��t ��{ؕ�FY@G!��H�8H=��5Kˇ`b���c���;�85�й��X-�
�	�}����W��lqk�K�G!�ķz��r��t�m=��B{_j잃�W�k�ڿ�����o�8�-ǟ&�%�v��^��Ꙧ覚�=���jN�����=w�4=-]�Y��;n�S1`I���e�Br̵WI���O���9.jz�����4�����H�o8,iܖ�:�>y�'mߺ��N�:(�&��VnH�=Ȑ]l���u߆z�[(��a���Y*�!eth��߀�6��4��Z��շX6u{Ƒ�R;�o'��ɝ�_���!�PO�@`��!2�:-+�;�y�tA��d�*����y�	����!g�+�(Zê�nf}��i�ܳ�>�U0g��8���0�p�:����lV�C���cÄ�#qK�Cf�v�@��~g�y���j�Rj�E��y�n��r���/���Y7�3�0���#v��dB�Am�v4��k�fr��y����<�ڨ	z�W8\�k�۹-�"a�= ����;[�'��F��<�+Ǭ�ŏX`j��˶7��
�g��sCd�D�Ď]DdH$;X640~H�'��Z�}��}�n�B�؃�g����Q�Y���cr�
0���cpڞk�C�h�#m��:��)27�x[|�uxe��&*`�������uM�9�h����1l+���:��bxQԢv�;���p8�qc��W@����z!Lv�x��q2�	�D��x4�/X���n۬��=�(��v�h���Dv�k�g��,%�傔����iܾ���8=���6Py.���x��������e� _���cT��[V9�YY1�Ru�\x�����i8 BG�e����а�ؓvϧ�)Fn �9�Xx��A��c=��-��)�ԓ��3���������M�`�:�:�ϖ����˭�ӑ��o��SUk�<J�ኼ������z.�� {>0k�����ؒ��������N?���EFN{3����s� \�)�,=�k9Ž�D�ݞOc�J���l�HP�������v;X�;o>΄�u'���2�q]��g;�&9/�V�
V��=K�<����(�Z2�ڧm���އݦ����w�F��!�v>:{�a[6~T�N�!4�%l/�Y�3KdbI6S�U��fU�"���f<��n��H�8��O��Nt���mv�Xms�*��8A���e�BrCw��n����}����=��A�Iܔ��4�[�* ��#��!��fg�:��ڲ�v�Ώ+�$�-�x<��M���xd�h0��N�`�Ñ�����R�9��k�M������}�ѿ-�Ãa�	�Y:B�#��'���	93� �mN�zo#���N�=����܀�)#!���<���3�M�uC�v����"V��-�µV��HX$}{����3:��Or��j��7�	��m�ف��\V4ZL�xD����B����.Y�3M���G������P�x� k��z����}3x��d��V�����-1֐�$ǽ�B��bȹ��Gb'�ӓ���{����<xéeF�l��ٸ�p�=�p?�Ń�eU5���|+�t}�:+n�.�����JU��`0Q(��c,�;v�Y���Xc{:��<�C؆t� ��������ڰs�:���os>6�zó��;�x���ڛ�RpB����c�q��V,�� ���Il�����r��|��]�9^<۳:�'Bo<��ٌ�q    F��Ppdѥg�f;��Y����x�]�I����|#���Ի�o�{&�3�Kη�}��j.����_n�>����yp�Q�!���i���4�7�4��=���d}��$��ji�;��e�&�V�,�V����ٶR�1Y ���e�p4킜����x���t���Ќim�ܣrǪ�~��q���@`}N�X�jy'x|[×�j��UbE��s���q�)���~8�p����F:����4�ǫ-p�/2��)����;��$�2:�<�@1����,�N�A�.�=G9��� f�S��b�=�Љ�lUV��1�C���q�˞	�sϜ)�u@��c�^�Ͻ������Z���� fT^N�}�Ƙ�i�W{O $���د�Ap��٥����15f㢞������)V�x����W��[D���1���+�1�)�2�'X��<�+Z7�A���,qk���}λ@�`��lY���~k��u�aAps�)\/�h_t&N�D;R�Hv�vFe��q�ђ������_���"���I�'a��PSJF)��eY��ݎS�S�Ylc�u�,����Ia��}�t�����4P0Ý0x˳���4��ჟ#8��⅖cW��ݞ(���;�t{�
�<��[���������j�����鷋{�U�lr�,�d`��y��W>a�I���b�.$�y�|�/��9O�q���Ki���Q�e�7�y0 P�� У>����������/_l�Q"�[��'W�K���յ����l8�l
[�Ϡp8��	�lx�<���D�'�`4<����Z�:=W�ZvSά����q*�IjË�a��-m
 ���S6�C�<ެ��ٞ�@DA��#�1�6���
��F�&b��xZ���qO
1�vf/='���/Th��Ԃ:���2��Y��@�ۙm3t�*��s�h�����b{1����Nt�gw]���������9�fހ������^7��9v�5����;[.�NR1�Z��Uba �3��#ȜCM�y��'��<�Yr�q�,�0�%�8�n�CN����?[�y"k]������?��6����˺z�!���f�W�<Lv��u[���:v�/��SKRM���<�j�����`�����lvsh��!*0>�A���A�������>��2��Q���p�'��Uo�����n�ߪT�*�qǛ9�X��n�+3�8 g��|� 1�٬]<u��.��f��� gS������:�q���iT_IN��[����{���|:R��"�%�	1F����}�����L���=�{�D�{N� N�ӑ8�%)�S��ol��4��6��2��3��I6q2�12&���6�#�8�b9��a�r�eǇ�������L�l��;���-v� j�*��/���Yw����o{�r��_s;鴉������CX�tk�,���]0���;g���;���9
�چC���<�=j���Rp���;�{�`���l��3�L�h8RqxP��k[�au�����h������Ą�����|�t��q%����=���Gs�7���{0��с�Eon���9��-�<�ȟ�q���2�(@�� �:�Y[b�����D	�e�qs�����YXl�����hqk�<�������@?0��C?��=�����	���j�����$f�(���͟ڙw��W�g�����0�1-/k�l�ǁm+��������m<������#�"�Oh���B��s�+F�<Rh4�l��]�UT({���c^VG����@&�2O�vU;�q,�=��xt����ڲn�`z��Vl�b�O���`-�4��+]AI��X^�d��%AQ�d�-�ko�̲�֭���1	Ob�"F���g����y#�l����F Ƿ�+�c�5X��d-�,��=��@6I��(�x����pi���/���`ح����0I'⺵�r�������񜝟���1�;���&��JyR�󽝶b-��b�0��٢6������>l��R_�9^ښ�m�u��&��s��00�
�UO�ʠ�w{XՑ�>y��4`�>��0�nx�u�����Oj`����tOj���*�r�:$9���;Ű�	p�X6c�2���V�B�kҐ�N=�^���w4!?�^ �d�?ܹ�R�2\2:XDf�a��sj��m�8V��G˷|���=��t�C��oֶ���"�z����9��RrG�d�����5s��o6�ln
H)<�Zn�,v#�CrEԎ��F�ѵs����l�շ��408�Ȧ���c΢�OGo����f�=�W�s��Q��\ɪ�W��ؤ?�sn�0�����;$�
�e4\�n�OL��y�X3]|�e=��J�Ȯ����Ek�.*l��⩟�̷���QP��i8�7-��@�(��n��H)��"g�&O����v�؄<o���}Z��ŭ`s�_Ǚ��V��S_���JUP��y��F ���l�b��hD����eJ�޽�Q��*�W�<Qe;2�װ6a�{��!v$���f1j�϶�3�����������?]�op�u��Yi���;,@0Ro@��@��i�95!ey�N;Gt2�5��ƀ�bp�6�+dk�ν�U��w���/�aߑ��7s;�"�7e��u���DxPXxv�=ΜTǶS��ʚ�°b� �iM_�4�
�ǜ�R��NVOXhCs���
�7�9 �$������C�r �g�m����hvƳs�����,ֿ�<�`Y =����$.��p/>b�T�i��VҸ��'���ܑW��:Oщ���)V�뱗�{J�|jӜ�������B.NO�Q�q��wOzy\���ѷ��>v�gG�o�����d��T�Ξ�v����;���N��0�l��y�躵��hߋ+32����K��Js���C��z�4|/wx��Bl��y�V�rw~j廗hӱ��Zo��H��cn���C�x��!��6��:�"�ᝏ���D�z���;a�X釜��q��c;�-��<��#�6̉?��ezY���ќ^���wN��
��O��7+�(%��x��x���m�ڀm����Y!���w��jd�?��xj�y�f�=��2��~Y�~b������_�������m�n�ee>"�Gշ���^��J&���&D}�����Ҝ�l2MO��0N�7������bĮ��lC'�fr��Gdq�ɤz���vf�l�cJ̪I��הZ5�����;����.E�Ζ�1x�1��j�[�P�;��z�Ӫ=�7 ��tgO��S���ĺ�1f�Y4�ns������2��L@�'�W�/1״�>,_��G�;ZT&`�)xҵ��<��XT[�Σ�;�����`ơ5�
ސ%��ݑy�H����>|�(�sJ���t����R���3#�9�^w{h=Vƌd��Z��d�uc������\�	r�C�^yJ-E���7�{U��4���e�:V+�}���f�`-K8���s�Z�!Յ������:��SpT^Q�����(�-��� �4�=��S�� ���
��j4L>|y�3��}� :�7��E���*jI��툛ׄ-?��4Nbͣ&(E�V>J�6TM��:�u�C��4��x�.���]F_<"�TQ���n�^��ɺ��lda��℮�s�������0����Y�!f#:��f��&���)�E�;�(8�D��qB>Lv��8	��S���!����P��̩7�9���c���m�WѢ�I�?L"��>e��M�D{��t�SRǬ����r*|ɞ�u�hc��6z�cd��Mȍ'l%�d$M'�>{h�/�{�A$R��z���0۶jb�^��K>=��G���a����I���:��b�Q�QI��V娯 ��5_(�D:Jv��<�m��^���]�O��9����nn9E�0=��s	�9�o�/T7Г�\�' �����.I*�2�K�L�%������C�N�J -%����c���    ��/Y��N��Ax(�u��~��
ݘ��SC�)�$���B�ƴ�����pL	s��~Mq�� W����vh�m�#F�y���oz�v�2��Z6��W��,'��Z�M�1G�d<����%�]�����5&6%�7c2���\p� ��fSݓ�[� �`��$j����l'��v��ʰ�RPh�e�����<������2�,ڭ[�g���#�Rǜ�b2�Vd�OǶ?K��'��gzH1�v�@o^���Ϋ 1Gqۦ�'�y/#�J~�-H�^ߍ�>�*�U&,~��f��O����l�z~t������r�E�%{���y�'8]���*d��&�4; Ե�Z��m���fwr_,�F�3]`b�B'*	��Xu����}K����+58��Q<�mIp���
�){ &�$C�����t9�s%i9h[��]ȹ��J#�RC�����dz�?钯�m"�4]�3�	s@OV���2�iD��[���&��	��x��X,.]~�^��t�Q�ɳ'6��S~�Z��LS�3{��F4r|�,�T��Rf�ca�D����3*i	e�ԤzI-��p�"�GGF���І���ȅ��	� _{21��L�G���[�8��B[�aԽ|�'�G�{%g�1ŎJ~�ӡК\��r3Ahz��m������~��=\
��J�=7�Ν2��'>�u�ؑrFل��r���X"'�Nu�`�剥Ժ�&E���6�&/�ᝅߒ#4ˋ�L��sE1Zn��i17�y��>JG�ZA�Q����mB�2���4�e=��ԉ�{^q�����s�}�G�Q����5	���T����$	� ���V�8�U�U�_����J�t���_S��~r���GZ�	`!�ZƢ�*��o�pV��s�aE7��Ta���Q�6ƈV���*Δ�i�d�I�r��%Vs,�(O�IS�����vnj:K�eL)N �<�<���0e�g=M���&�9��ː*��Ҏ��Er�B?��&�}������Wͅ,���wq��t��
Ń�%_����%��DBLbzY��t�]�����PC���n�2N����K�q��QJ��s��Ř4-�����>�&�a����k�i�����
�Dr�DtM�6pJ�,��ɏ���♱�fzI5Wkx#d?���T����un`
��
T�wj��q��DU�e%q�.��n��T�� IMyŅ`$��.X1��M�3I];����O�<�+��(ݬ���e���j� Ku��_.�R�4�,�jm�ߔW	��Ӫ��UtOrԖܟ9�@�5r+%н�r���"=�����vN�^��d���j}��e�٠�|�i<�w�C�
������������d�,)9�1a.���^;���rjwص�I��tt@d�$E�10��R��^�K��s���&ĖBC��X�r��A���C����>�4I\��D�������$��J��W���9���ޅl�-���kY~ ��[����7b3�D(P��-�g�����v��)'fc�����.��[Q�o9\]kW�r�|��~3�a��H���<9��aH���>IV곔S��!��yN��=yʙ<ħ� �].������%.^�Vs�y����8z�X.�"��e�{�ȀD��d�2�\N�j���I�4�R.7\�/�����P����[6Ͱ��`�����S��f=8R��ii�·	�J�n�G=���'�&g���_2Mi���*�{n�޳��n��!�Ž#[��X.�R	����I�j$C�����{�n���+M+-�j�&���B�9q(��3,�]�
��jRʟ�t�
�cZ�/,�"�E��}�O�a�-�&p�ɥ��K1���Ӑwa��q��O��� �˖`���3�v�ou]�p.&N�%���2Xw'�[uK�]��d�r�F;M��ζP�&���ʤI�*l���Y>�w���$�b��vfG�ꡄ�mR�7��K���v�4�l[�ĩ��)Tj��,��ٛb&_����@2;�ݔ.��i�v�:�В��:�)�s$k$��Z{�m� dXzi_��\S K}���?�W'��;!��],�\���	���}�Y���S��8�Kn����A���1�\f��>g�T �m�17��t3��(�{�r����8�q�1�c�̓f���A˞�<']F�$ϙ��2��s�Ќ���
MG�[O�~+,��Y.w�L��ʜ�޴I&�?�[�l���<]��g��gb��v�O���[��?�@��2�#��,���ěPm0��e�{�yӓǯ���e��pNd�h�jZ<��?��g�Z7�cM8S�M�	��B��|������%A����q5�H�Z���n|rρ�d�C4�P����5ä�R�$wI��2:wݚ弊������f�h(^�9P�L���^ɵ�zo_��.C'���D�L�uQ"�kv�:u��e�ez:'���#�џ�<�����-_Y0\�꼡5��P�9�X����`a�����#igOe`��T/�1;̓NA�Gj��M��Pǫ���Ә���z����Ňkʣ���\��4�����$���������d����E�2��)a�r�A������N|��7�Ƿ����)A�,\��/��`P�$יr�$��|RV�wQS}Yuڤ��e#�'����L�+�*���ʗ��E�Ҕ��ӣ�E�F����//��F�]��ҏ�=�Ϛh'�>�WfV��h�)`Ҁ��bn�6�h0D��NZ�w:�+���r`r�Oԁ�s�,&��V�󂼻u��l�� g��k��H� `�*Gņ�z`8]om�\�/E�9��5.�����Q^.���l$BSS�z[�@�^��Y��8%��V~�˭��z���4�v�����P�۳7�8�;ZG�ro�8Q���V�7�=HI�/��v�����%˜�x�i�#�O&�A������=�Q]n`I�N�f�������Q��}�$m)��IA�Ε8�<J�uϖOe8C����B-),j�/u���T���CW�=�J'�+m�l�37Wj��%ȧ}���%"�2:�S.��C7�9)��U>F�_bjV�ݩ�o�8�ﹰ�N>[����%���$��pm ��h���H�t�����煓b}����"Ψ��R,���gkm>i��# ����)�S��)4�9;��q�������6�ay��^VR����C9���[wԪ�i���`G��P��+�~'"�΢䧮�RSdב:�'GB�L�@;�0i�}�B���g�5<ޜn��h�2����7�r���iGk���O�|j�Ϣ�����Yi��;�>~M5�[R[�^K�O�~���TM��)�D��ѠK`ȝJ�41%�f�A-������qq^p�W�H��vI��>�}�j�����lb�ɒ|���5�4�3������k�����&���<D��f���n;e�R-��u,���q�]S4]$���+�i���vKB���������Qb({�Ɨ���8 �dP�U���|S�?;��K�(�ow�ed�H�\p=���9�WΠ���%.m��̄�/���?�����U����(�)��%9�I3U������&޹�Wm���}A���r&;���a�?3��M.x�} ���kwڱ�Fr���A14�|�q��1�Wtf����%���x���Lp��H"�X2W6���A�_���~X���S�H9ml�/`�;���{�"��B�4��8)2 �Ň��Ѝ}���i���9<�7�l"��d��o �,�(�\O	�9:�K8��|i}Y�&�D!ȔE���/)��{X��*�������Bw1d̡Jy��Q"A��
�
�y�.t'X�\��r�y�f݉�r���A�I�نk�GH��:;�(���c�?\���� �e�����N���83����W��ӄL��=��l-owk�����H �c�l��~R����d�a���D3��@��M��ʻ�NRsɑ��̹��:����h?��&&�J�9��N�hO�o�cI���4�x�u�M�+��Һ�    ���Ė���x��$r}�Trg��^f���T(K����/7�܎�ؐ�O�=y��QEƔSgp�|%e�!H�2fL�w}eȞ�A}`���a��*��)s��6���dRn6�)�$���lO�3I�&�l��ڱ�R'�"{PCOIqo�>�ԴlMH�çi�,���lzƋ��@��s���_�r5���j���̷�i�W�-9*�G
�5%^�;�(	7C�A���P����^�s�����v�])��m�Y?�F�O����j}�D�&�L�������fyt������;s:-�w������S���tM8Ǥ����SXk?C֒H�V�ϗƖTw.P�����9��9bl@�wqO�C��%�r�'��yl%��A*/��.�7�0��'��s�$E�SB��NE�AʝI:��,�o;>&e��5Ya�j)1BK�xSp�|�i����J�$�TdP#�\@��E��z�V��ʒ��)��,P�T/���9�7_ \���o��K�$Ҟp�I�Ϫ��%��A드�<��zB��DoVlx
�J	�y��q뺪�jY��o"�~#�lQSKNT��~�H�a"5��r���6;A���m�H>�?u���9�	�K����*�78��fݝȆN�^
 ��|�fD{�!/oE�XJ�%���)��Y��x/����Z����V�n'���������2#ȉ����XzYq��S���{�"�ˍ�����#��V=�\���&�=��\9�-_}M.4��xI����X�oS:��4��̓����c>Y����S��Q�YĒ���A�`$�ӄϡE.�z�r����5�T7T���S��ө���0؊�Qj�`3\�h�����دE&���K�ў���̒��d�Cq��/yQzA3� �ߏUD�����~rM�sǑ`I�&�RD�;gT�l-wD��%3�����Dn�4�߶��A_�����G���H ��݆ ���",��W�N�aU�A�vv���-P�7����	�}R�O�yX�_#�vc>���+w�B��^���Fs�'�w�0�kCP�����x^�a�d�L�듇�G��9Ɏ���Y?k
��g-.B���HZZKU���]��qWC}Ҕ@fYn����gr���W^Lv2�W�N7�ʁ�dEPrYK�)���IF�^:��Y��]���#S�Y j�.I"����D���R��R�pD�Gz��ca�����54��&_)���@0G�滮�1�f�J�s�������i �ۉ��1ZXɾ�
�� �����;�C���Ef>( �p���r��:Y��]HI��>�H`���3Q�������%���}%�5����`ՠ�<�d`�F�q��H���gI�;Ӽ2�9�.�$�o�Hi�~?��ؘ�zfĳ��Y�1�)��5��d�����뿗ӃXѸ��2_���JT�@C�M>��<A_s��i8�$��ug�-�P�e|l8��)�J�c�eO[��^Z1([�C����3$��~�ƚ�t��US�o���˝h�h���~	�aҍ̍�`���8�7=��q��/C��t����l$F���a;�c��h�|����<���(+�qЬIQ�H��N�[��қZ Iif&3"���b���*ܼ9�y�4��r'�I��=Vn �k1��p?4P�S.��[u���T/s�
yQH�:XS�gkܩ�>V`)����i��G�N�+��L��U9wy����9�Y��s�-D��,��R�~!�fl �D:��o���B���f�LnEq:&�,_�߻�Hw,(ԷLR)ܒ\�/� �T�d�9�w��N�<�WTi�ހ��׶��7�SG��	^M��=�QD�� "���t�����Ɵ�to�g��r���Ty�4�a��?�N�U���]���h[n��dK�H�)�B"���*Q{� ���̕b��D<�^����!H�w�f���X薚Mr��3T�	~ҹ$$C�I)����"�L��	rI�n�q1�gt��S\~A�o��5%��q��7�(�沜S#���X�%�g�'�2$փ��.�C����6� kIt�s�X��Kl��)�s�&���*�̍ڱ?����OÍmH�O	��{��!	�����������M��v(O�Ĭ��� �	��k��z�풬��t
�$,|`���7WX�S��͏��͚B�K�Kz�^F?�E/�߳T韄=�T�|�m��5�!�p�7��d��?��Yv�<C��a���%#�!�(�+��T�FSt�P��Qt�TsGO��	�G
���-��A�'���H��3ox�2I� �/Xf��r��@���#��o:H2ΩD+;r�OWխ�<	ICY��g%q��~���:�r��m{Aw �D�.!�+����%�*�"�X�1��&���B15a~��3�(����?�tO��GY�y�)ZQU���ӣ])�6>�5]�qh�h�񤶆.���������mN�3�|���Ey�3���'(;"�����;ſ��y�>�B'`��g7oK�yѶȷJ��Ü\Ŭ����9%�f� �h�)��~�x��T�^����K9�|L��S@B �K���',)D7���wi��Ȋq'���dd��&U�z��Ҥ�����m�@A�<)�S�n����6�$����eZ�S��e���aM��^ȫ�++$��G�Ϫ���[���ߣ�L�R��R���{��n��>&5�����P�M_���*j�v�� ��9�tl��Q��3?N�z���O~w=+����XE	XW㙐$;�CH������?C��m�nϧ>�:7��N�oEu�s�B����U$�u�!w"w*���U�^O��D,р����5���l�+�?>k12O ���YJ�N]uaV�	�@\k���f�kL�%�a,��t�[)"�w��o��f�S璫Փ�`�'4w0�=k̥�n+�Dԟ�8�J�G:�$/rX�"t:l܋�9%��Q��q��� �r�31ͷ< ���'�)��Fd67~2��aa�K?t�a�9��(�eG���U�=�Uv��gb����L��tå�r�Iu�+'�y���U�I]��%�K%g��L�|�����c%�~S����a�@�K_�gڝ��x�Nڷ�d7N��E!�?�t+�R7 �R��r;���<]TV���N��@��}�+�c��
r/�!���im���p҉�`�/$��$�e5r�%�V��b�oز��҉弐t�-կ��԰�/��RN�`����+�,^�<b��ګ1e���&c�!��a7u9�k]��u���{��<$�xZ+�/��|�B�,w�~E���)ժ�Z�p=�� ��kWvcc��/��tr@�N3�$��]�w��&���#Gjҫ����Z���QhD��T܃�K�`��/�*�8�ײ/=�� ��sc�ۑ����Z����M��hI�,ϓS�xH&�L �V�z�������^0��5�T_S�uۿ�p8�潒�ohp�)
?�3G]]Ӳ�Kx�g5�N��e TP�t�p���f�>�zX���m	��5��yFs>=p@���5���h���dXk����f.�G���8S��rڽ@�>�˧C����r��z�~_���1dϳ�t����O��m�-�R��Й���I�	�,�q��q�9k�./�g�|K�L���_�i���N�\�TZ�=Q���L{G�D?Sx�����P*�Vm|���jw�Br��Q���z�e��l�+��ʔ*����g���s��	�obѧs��ϊ��<h{U�R�-EՒ\�������b�����W1��!�<{�C�;q��zF]+X�K�U�:(����:7�ɍ��AT��@{X:Mk�rH�=�UN��j� dfup�|!�;�:���悑\xL�U<scr�l�gu>�r�hŚ� ?y��X�gbh� �rS�NNrU��$�lފ�������PK�zO۠�����C='�o�ܕ��-\�&����K�ϭ|�$�qŚv�쫙�����2`ݒ�&��5�W��5?7jD����?��Ȟ����t/\e��dK�_
���75y*[֝���ʪ��^R��]5�c�0��[�g(08�8�I��;Eg*��    �Z�����Ǌʹ�_I�u�@�uxIꢧ�[*٬�k���T4�V�1�l>
�U��hДՏ&f�����sƶ~I��;�G��K��2�L$ZIP�4�!�}/쫈���9Ӯ=@�܈4�d�-���m���k7�J��K�k��Po$+�a�Z��!{]
�^6#ܽiu-�a`G�ܛ��J⁄��l�M�Ñ�5J2�h�]bL�>��w��7���\�ߋp7o��A�����4��
������mr�L�S"Æt�,9��e�DNz<�Q,E{�	8mK�Od]x��)��|b�[�xi�M:�=��
����6M���+?��O������6����6��3ݤ��y}�q)��[r_~+��N��r��";?���'.u3���2�֭
��<K[��?�yBH%'@�,� zYş�au��\��P�Zv��%i�2
����e
btE�U�^5<��̍���������3 �v�G)hT���V��"��WB y�������a��oN�A�;�iG�$�g"����Ӭ���lC+�b�E߾�IC�D$ܪ���Mɣ<ɬKq�St_���Z^������w�Y���w��2iV����]꾤���`A�@>��MŮ�u� ���ԩ /�����<�Š��Q�/�Y��Etf{e80� ��K��r��k�!9�8�l����"�a;t�H)2�DG���hn��u��&�"2�{o���#��]����t�f;S��e��H.�r	���q�Ξ�	��HY�`�N�\�����2d)�)ag�!���)&��t�l<��I3!2�����i��T0W�㗝.� V�%ӱ�#�|<�A*-]���D\Q�5$(MzV{�U5���x�4�u���/���z�<eI����f��;y�8,�X  k�wn��jƑ"�?�${Ø �����Ψ��\���B^�����#i2����ƥ�/�\�n��KS����l矐�=8�%r�=*`?���a%�&��P�8��c����Q-���7e �^���]�>���\�Ov~6�~���Њ����+�s.BX�냠�u:�f�U�N�6ߞ����@!7�\g��m�P��<���,�Z.X�K)Q�Ql2���~w��V��3-�|bl���Zv_�TY�l���MN n8%��!P����NGf̥6]�A�m���H�訛6�����ﲏ�N���x/l�uN!�>�(�v|'� Ϡ��tMz�Z�gWu�6��y�9�$a�O)ˮx��%꺽��O�kR�o���!P�'ȝ�0�S��h��l�Aؙ/�LR�k��[B/6A� ;��a ���3�G�Ğ2h������]p�ר�F7g᳓���gO5�ϔϊ� ���V��]�F����{_d��HqF������1�.)? �O�+���5_{QS���/�%yWG�)5d	]�8�A/���>"�zn��P�����'��ᨷ��l_�w���q�7 ��H�S9o���`�n�L�Mp� �9��'�@*A	A�:x�����͈���2����|-y47�l���%�RyG�󴧢���j�%�O����(��.�E8���O�=�\���ZS�t�H�Deˠ)��D{��og��t^�=��g|��tG���p&H1��H�R�2tL���閕��Ʋ4�y�Jm��'f4�# ��`?!0���7_P��{���':���-���ێc�
�	�G�6!��j��D��*�w]э�H^;������r�����T���IM}s����/!Xǜ:��b C�>'���K�������&��^s��
������1�a����2dO�\��%C��w7	�uX�3�<��Q���U��"�/Rb/9܀Lt�?hT1��n�RY����Ob���^����>�������)�5w�w�#N>�[�@��x���%!Xk&�^�(@�3����3>�����+�+��7�������W=�u{�If�ܸ�#Gv7Q��_��-�҃x4<̶	8~���`��!t��~R�36���[*B��%�gL�'/UX��vr�/X��\ʬ�i�~T��Gt����fXU$��F��@6>Éx��_:���.�1���l���'ռ��fؼ��q9��q���cv��[2Z��V/��O߀af~�5þM��y	4��+��m��0w3�ӣ�����S>�H���j2�u��f��2WVVV!5<WYS/x7@HD�E���$��<��5L��,'տ�S��V���B�d9�����#�xi�C�n�����w���_F�s.t�0�K�Nf��A�0�Qt-Diȥ�NG>�$�܎�lإc��Lim�3Ϥ`NĎ\�)�'ºpg��
:%��ЖmX��D2_k���z�A�(�WF��+��-g17@�1'�cW�m��0���Yv�\���C*�A3'UGG{I��a.bÏ�漴��Є�q�=��z��&!-��N���.%ݟ�%�,�2��|%"=7ep9�츹�e��)�8�0[n�M�f�?X�!}�<�c߸���\K�I���`�ʈ4� ��pf��k
�^jT�Y5����06`�+Le e��w~� l�'/��'U/��\�fͮc��VG���B'!A��0W�E����������>"�����=�(շD~���<%�Y��+������K�14���$��F�\��8(��q��c�6�j�)�ֹ����̞�1������K�;��jK�j���eƚ��)�� ;��\�m?`�d0YjX��7.�ܧ9�՚���@���J<������{ys&�A�����#m�9bR�u�Ľ�4�x�b�����w�ǆѷ���]R��1�zɻ��φ
�"8����u}Y+]4������Y�٩�J��It��^�<]��9����EC�?;�����rr����8n�d��y󽅁�K��3��I5��M[[��O֯3�H:�П�L:��j��Yb0B�s���%a���o8����	L���Q�@,Ӷ��'�8���%S�{��},��G��:�xI`�^���)�Pӫ�YS��
ñA��Ht�9��r��%�b��u��sN�`�G���Q������i}�D�?7퇱�QbU�4�t���B����*�Ӱ%k�H��b�y�m��L$��\r �oR�]g��j���\̀�^j	�djp.ѫ����0�;WE���Q{M��`9�H�>9�.�D&�n�k!����,ȵ����$�+Ɨ/�o8n-�̳�>��]�sU��\e�Xt7�$�<�_s_��9m�m���Ԟ��OIo%NO��0�s�_�}h��9��M6����V-G���c�g�P��G�l�T�6��	�"Xopk��K^DC�͕7�E����<&�vMÖk�
�	v���,(u�7��z��8��d�'x�'��:2��Ƌ��@����E�S��*/@`���N*� {&W���L$���M&?�Vɢ&.A��7R�V�P<��aso '�|��J;	��6�El����Q�M����l)\�+@fBʃ�H2�Hvav����b��=l6��$H�0��-rn�-ŰYC���[Q���%]�A�.?05�R��K�q��%몚u��H[�ܥl(g^_$�YÕO_���R�BC�ȵ�4}����m4�Z���A2��1��^��s�HI%���0�]�$Uh���ΛZ�SG��Lk���6�^#�X��^_7���F�gs5LJ����钝�f�~��D~��>[ejh��H�^r��&y+�2�|jě+}�(�+���۵x3B-SE���M����)>��s9MeƆ7ػ'�O6X��K��(�л^З�챞M����˓u�� aR�C���YJ�Rm$RYF��E�	[�SE�<[�,W�mb��<&�'�y��K3��|R ���c��k6w3������6�O�CL7���	_>r�B��!v�d�4�LG��o��0��5�;Y	Ϥ�H5�r�A;����R����ɣ��v.�BO��H�BX�-'u+�����}����xh��ì);���"���N�H�<��&��[�ʸJ3m��'mݼM���s�uN��<�4娉<s�	��/'���!�$Ó�V�.�L�v� }  �{�ؽ�6W$ͷK��H4,k?�3���s��e��S��g�mI#�rrm$�n�ɘ�A���U�Y8��1�%O�?	�#���s,)?�~,���Q�Ԥ��T����\�r��Q:��kH�$%���Dn*R)��d���[��~3��˴�K?�+�$�;��QB�y�<�0������l\�p��q7�m�( Θ�ȴ��	�יr�kG*�I#�1O:�#�陻���-�n	� ����f�XM��\����e;`�S �.�1����F�ɾx��O_�fUS�!U�����wnǹՠ��'�R��ܖ7?]���c�w���\�$'�R��Ц=��<?:�]QA�iʕ�+��zA�^4!���vx���8]�;Oʧ���=�s�]-�=�D��?�pO*E��B��WB�*@nZ����>��8T�8��^`��y�<��B�VS/����ܲ��;�}��)Y�CҺD���J��28�Q3RK͖,��Ƀ>N���U�+�I�E�)^Zy,	��E��	�,�79%�N�SG�)w	��dLyr�*�����JR[��HLޛFR"v�{�y��n��\@9X+�i��OA����
4ч�A"�h�o��s*��}�u[i�-�r��)7���Ӊ~4�w���vFi�'�]XV3^pKA��	g�H��ZYZ��k�}�/"w���m(�q���nd��v���a��2��﹉�͞�ȉ�س�w����yls*v�d������{������p�>[��ǅf˪���	$���l���Mؽ��>[ٻ��S#���p^?�RV����ߒ�<9�rע����	��b�`H�����k�{�����? .��N������	�d��5���hވ[���&����i=CS�1�R��l��)k����h%ܛ�<	�Cؙ >e��?�`�1��<�zON]����:�{��H���EJw�������J�r̦��uz֕���} _Ж,Yvvv}���=O�o�p ���/�l������C�?@V�C���߉�DHΒ��Y��Ğ�9�yp)��/��p��PS�34蒒l&��t5���l$Ea��>����]
�F�R��3�7�r�H�)�)K��$�q�x���@<j�(�J&PZ)?��mOS�,��$��$�u^��%��n���0<���W�sNpfZey@R����� f��AWUe[�X��(�������P�+���@4��F+������Wͬ|���1�����r�Ė9��+;a�~�~�����3���o��_��ύ[n^�y�ST;��;�C۱aC�/��X�{."ߡz������l���z���S'�b8}Ш9�$������g#5���kn��0nk�M����b�!S�݌͊��ONE�a������?����/"��      �   �   x�u�A
1E��)ri;��2�F�V:�0�?��ڍ`����d栙8�������[jٷw4�`��%��`����녣�:������C7EC8� ��j���cf%x�)�=�E�L�N���"� �-p      �   W   x�3�tsvUpqUp
��4�2��wq���y�9� �9�C�BPM8�]}=a<S�� g� ��P����'L.F��� C��      �   m   x�=�;�@���9"�)_�9rb�k�܊#q1
$ڙ^�A�N
=��$�Ɏ3���?՘���6���$�F�6T�Yt}<�79�
���e4��J���xm |G#�      �   �   x�m��� ��s^��1z� ��!aƃ�X�%�1%g����w�mE�5���G�'6k�5鶐�=���ӥ-&A�����6���Y�9J��m����N�4��YŁ��U9=��o�M�.Iq�}&���<�      �   -   x���  ��w�K�J�m��:�kd�[V
��ej��F��>���      �   �   x�u�K�� D��SpG�O�e#	�[�H��9�!����^@���`C�����`Bm�V���=�z���x*�W��N�3�n���Z��l�a�
��C��A�.��-�g/ |( rP߯Y���]��;g���}�� /�.���zf�-����4�Ҧ�`r��	SB�
!�/��4Y����j�,!��!/��'��>�	?BmC�<$�w���i�_��o�      �   �   x�M�;
B1 D�zfY�8淪��S���:�$�ts����~܍��ҷ��ڷ���w@��wD��wB���k��7���y���/T[�:�g�ց� a&�-O-���X����A�LT[���3)P�B탤�D��"uRf��֙��Y�R�      �   ;   x�3�4Cc ��������e61��8:�C�8�̡��A�
>�NA�\1z\\\ ߶      �   J   x�3���uR�t���2�vu�s�	�*Pp�	r�2AS6�q�sqTpqUp�s�q����� ,�      �   {   x�3�p
�t�W��sur��t����K�W02PHIU��/�L�M*Jrr�bFF� B��P�Ȁˈ3 ���5�Q��?���őӧ4/�X�Ȑ�^C.c�`W�P?�^�Ģ�fcB���b���� NO2      �   �  x�RIr�0<7_��F�,>B"��X�PLlW>�9�r�w��4FUB  6�l�]vQ���9�0�l��u�$搫^kF�=��Q%Q_ %�*33�puW��d>��������bs_ :����<4�>ё>J����7$T�X���8�X�:W7��yM܋��u���Y��d3�j�Q��D�,<#�]����"%�ͺ�G?�leW�mr�CK�0�l�4� �F�!�9,b|(�jNx�v�Mxl�����5O����4$�?>9�iAq��7��47X�T��k:�W�q6�@ͅw�Y{[�"��A^�`!���*cX�_����nsӝ5�	ӝD̲��Q�LEމ�ܢ%�U�T>�U.��U�Qt��i�ƪ���C��Z-��#O�WK��䇶�/a�~�������K�do��7Cz���󿺎*���?�_ߜs�VۘJ      �   >   x�3�44�20 "NC�2�44�����9���\&��fpAc �4Ŧ���=... �/�      �   k   x�%���@C��c�Z��V�X*F�����t���K`�޳�+�ޓ�(E�0��Is����ǪK�)��9�Be�ޱ;���ԩ���'���W��_��)�y �f�)�      �   |   x�eNI
1<w�b^ �{m�5ؐe����Ì�x�TEmԞ��^6�)f�U��\]"��8�(=*qR8½�F�ӟk������gB��TFM�2�_���ע����F	j%HZl�B)(�w���R-      �   �   x�M�M
�@F��)����5�L�h�Ma�=E�Ջ՟�
	�x��I�!��� ;�Y#<_k2��zT�~	��X���@a#5�p�bzV����l��9 �b�ꨵ���x�X�x\0����N�N�,Ix@�q�W�>O��\c	��\��IZN�Ǹo|�2`��8�P\C�      �   ;   x�3��uq�2�tt����	rt��2�tqt��L8�\�]�B�21z\\\ �xE      �   9   x��� 0�j3L�0����sD�	������\�z�o�q�g>fk~oH���
      �   $   x�3���Vp��t��2s|�C\���b���� |\-      �   @   x�3�tv�;ܩ�������t�ב��5�ˈ3�3�Dps8;����X\1z\\\ ��         &   x�3��	�q��2��q�q������ l��         x   x�M�;B1k�>?Ak�0B�q��+q�w1��3�-���y�u~$t���E��9%ZO̸q����ki�*����W�6�6Gh�f������=L��M�h�Z	_D� Z�$�            x�3�t�Spv���2�s����� 5 >         �   x�Uͱ
�0���y����aJ9	�$4 ������A�����?/���/�$�@�t8!<^��C�3�U9p0r���r�R�����	����S[�=NR9�o�6ܜ�BN>˘��9�L���rr�y(�s���5�n�7w�+�>Vx,)     