PGDMP  :    9                }            LanHouse    16.6    17.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16397    LanHouse    DATABASE     �   CREATE DATABASE "LanHouse" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "LanHouse";
                     postgres    false            �            1259    32773    tcliente    TABLE     �   CREATE TABLE public.tcliente (
    nome character varying(20),
    email character varying(40) NOT NULL,
    senha character varying(15)
);
    DROP TABLE public.tcliente;
       public         heap r       postgres    false            �            1259    32778    tmaquina    TABLE     f   CREATE TABLE public.tmaquina (
    idm integer NOT NULL,
    disponibilidade character varying(15)
);
    DROP TABLE public.tmaquina;
       public         heap r       postgres    false            �            1259    32796    tsessao    TABLE     �   CREATE TABLE public.tsessao (
    idm integer,
    email character varying(40),
    datad character varying(12),
    tempoinicial character varying(6),
    tempofinal character varying(6)
);
    DROP TABLE public.tsessao;
       public         heap r       postgres    false            �          0    32773    tcliente 
   TABLE DATA           6   COPY public.tcliente (nome, email, senha) FROM stdin;
    public               postgres    false    215   �       �          0    32778    tmaquina 
   TABLE DATA           8   COPY public.tmaquina (idm, disponibilidade) FROM stdin;
    public               postgres    false    216   l       �          0    32796    tsessao 
   TABLE DATA           N   COPY public.tsessao (idm, email, datad, tempoinicial, tempofinal) FROM stdin;
    public               postgres    false    217   �       "           2606    32777    tcliente tcliente_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.tcliente
    ADD CONSTRAINT tcliente_pkey PRIMARY KEY (email);
 @   ALTER TABLE ONLY public.tcliente DROP CONSTRAINT tcliente_pkey;
       public                 postgres    false    215            $           2606    32782    tmaquina tmaquina_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tmaquina
    ADD CONSTRAINT tmaquina_pkey PRIMARY KEY (idm);
 @   ALTER TABLE ONLY public.tmaquina DROP CONSTRAINT tmaquina_pkey;
       public                 postgres    false    216            %           2606    32804    tsessao tsessao_email_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.tsessao
    ADD CONSTRAINT tsessao_email_fkey FOREIGN KEY (email) REFERENCES public.tcliente(email);
 D   ALTER TABLE ONLY public.tsessao DROP CONSTRAINT tsessao_email_fkey;
       public               postgres    false    215    217    4642            &           2606    32799    tsessao tsessao_idm_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY public.tsessao
    ADD CONSTRAINT tsessao_idm_fkey FOREIGN KEY (idm) REFERENCES public.tmaquina(idm);
 B   ALTER TABLE ONLY public.tsessao DROP CONSTRAINT tsessao_idm_fkey;
       public               postgres    false    217    4644    216            �   �   x�e�A
�@E��)<A�.t��p�&�X�3��퀷7S�)I����I�Y#�u��@�A���c*M�nmЙ�ha��y{��~ߺ'�G�)�U?}�������nB`S�ϬY)�UL,`S�.�F���۝}�%5��G�Huh�6��y;cP      �      x�3�L�,.���,K��2B���qqq �b	�      �   X   x�3�,�L.�/rH�M���K���42�74�720��4��20�4��\��U�U�T&攥��f%`�f5( ����� .%n     