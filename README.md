# Conversor CSV 

## Sobre
O projeto Conversor CSV foi um projeto desenvolvido com o intuito de treinar a leitura e escrita de arquivos em Java, desenvolvido para o curso de aceleração em Java da Trybe.

## Desafio
Você trabalha em um sistema que processa inscrições de pessoas para um evento nacional. As pessoas se inscrevem por meio de uma página web. No final do período de inscrições, os dados de todos os inscritos são compilados em arquivos CSV.
Existe um subsistema responsável pelo pós-processamento das inscrições que suporta arquivos CSV. Porém a formatação das informações que esse subsistema espera receber é diferente da formatação dos arquivos gerados pela página web.
O seu objetivo é elaborar um programa em Java que seja capaz de converter os arquivos gerados pela página web para o formato requerido pelo subsistema.

Os arquivos CSV gerados pelas página web estão disponíveis em  './entradas' separados por estado ('sp.csv', 'mg.csv', etc).  Para cada arquivo contido na pasta entradas, você deve criar um arquivo correspondente com o mesmo nome na pasta saidas. A formatação requerida para os arquivos de saída é a seguinte:

  -  O cabeçalho deve ser o mesmo dos arquivos de entrada.
  - Os nomes completos dos inscritos devem ser padronizados todos em letras maiúsculas (acentos gráficos devem ser mantidos).
  -  As datas de nascimento devem estar no formato ISO-8601: aaaa-mm-dd.
  -  Os números de CPF devem estar corretamente formatados com ponto e hífen. Exemplo: 123.456.789-09.



## Formato arquivos de entrada 
Exemplo: arquivo sp.csv
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,29/06/2001,tapereba@gmail.com,81627775471
catarina mafra,28/05/1991,cmafra@gmail.com,75157671466
bento naves,25/12/1993,b.naves@aol.com,88826690685
Lurdes Neves,08/04/1985,lurdes.neves85@verizon.net,92277079138

## Formato arquivos de saída
Exemplo como deve ser a saída do arquivo sp.csv
Nome completo,Data de nascimento,Email,CPF
IRANI TAPEREBÁ,2001-06-29,tapereba@gmail.com,816.277.754-71
CATARINA MAFRA,1991-05-28,cmafra@gmail.com,751.576.714-66
BENTO NAVES,1993-12-25,b.naves@aol.com,888.266.906-85
LURDES NEVES,1985-04-08,lurdes.neves85@verizon.net,922.770.791-38


## Arquivos
Os seguintes arquivos foram desenvolvidos por mim:

- `/src/main/java/com/trybe/conversorcsv/Conversor.java`.

A Trybe forneceu a configuração inicial do projeto.

## Tecnologias
As seguintes tecnologias foram aplicadas por mim nesse projeto:
- Java;
- BufferedReader;
- BufferedWriter;
- Manipulação e escrita de arquivos;

## Como executar a aplicação em sua máquina

1. Clone o repositório, e entre na pasta do repositório que você acabou de clonar;
2. Instale as depêndencias do projeto com o comando `mvn install`;
3. Rode e teste a aplicação através da Classe Conversor ou;
4. Rode no terminal, na raíz do repositório com o comando: `java -cp target/classes com.trybe.conversorcsv.Conversor`;
5. Esse comando deve criar a pasta `./saidas`(caso ainda não exista) e ler, manipular, formatar os arquivos da pasta `./entradas`e salvar na pasta `./saidas` com o mesmo nome de arquivo;
