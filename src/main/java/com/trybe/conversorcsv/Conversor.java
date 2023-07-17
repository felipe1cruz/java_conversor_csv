package com.trybe.conversorcsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Conversor.
 */
public class Conversor {

  /**
   * Função utilizada apenas para validação da solução do desafio.
   *
   * @param args Não utilizado.
   * @throws Exception erro.
   */
  public static void main(String[] args) throws IOException {
    try {
      File pastaDeEntradas = new File("./entradas/");
      File pastaDeSaidas = new File("./saidas/");

      new Conversor().converterPasta(pastaDeEntradas, pastaDeSaidas);
    } catch (IOException e) {
      System.out.println("Ocorreu um erro" + e);
    }

  }

  /**
   * Converte todos os arquivos CSV da pasta de entradas. Os resultados são gerados na pasta de
   * saídas, deixando os arquivos originais inalterados.
   *
   * @param pastaDeEntradas Pasta contendo os arquivos CSV gerados pela página web.
   * @param pastaDeSaidas Pasta em que serão colocados os arquivos gerados no formato requerido pelo
   *        subsistema.
   * @throws Exception erro.
   */
  public void converterPasta(File pastaDeEntradas, File pastaDeSaidas) throws IOException {
    try {
      if (!pastaDeSaidas.exists()) {
        pastaDeSaidas.mkdir();
      }
      File[] entradaDeArquivos = pastaDeEntradas.listFiles();

      for (File arquivo : entradaDeArquivos) {
        File arquivoConvertido = converterArquivo(arquivo, pastaDeSaidas);
        System.out.println("Arquivo convertido" + arquivoConvertido);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro" + e);
    }

  }

  private File converterArquivo(File arquivoEntrada, File pastaDeSaidas) throws IOException {
    try {
      File arquivoSaida = new File(pastaDeSaidas, arquivoEntrada.getName());

      BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
      BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida));

      String linha;
      boolean cabecalho = true;

      while ((linha = reader.readLine()) != null) {
        if (cabecalho) {
          writer.write(linha);
          writer.newLine();
          cabecalho = false;
        } else {
          String linhaConvertida = conveterLinhaDoArquivo(linha);
          writer.write(linhaConvertida);
          writer.newLine();
        }

      }
      reader.close();
      writer.close();
      return arquivoSaida;
    } catch (IOException e) {
      System.out.println("Ocorreu um erro" + e);
    }
    return arquivoEntrada;
  }

  private String conveterLinhaDoArquivo(String linha) throws IOException {
    try {
      String[] dadosDaLinha = linha.split(",");
      String nomeFormatado = padronizaNomeParaMaiusculo(dadosDaLinha[0]);
      String dataFormatada = converteDataParaPadraoIso8601(dadosDaLinha[1]);
      String email = dadosDaLinha[2];
      String cpfFormatado = formatarCpf(dadosDaLinha[3]);

      String linhaConvertida = String.join(",", nomeFormatado, dataFormatada, email, cpfFormatado);

      return linhaConvertida;
    } catch (IOException e) {
      System.out.println("Ocorreu um erro" + e);
    }
    return "não foi possível converter arquivo";
  }

  private String padronizaNomeParaMaiusculo(String nome) {
    return nome.toUpperCase();
  }

  private String converteDataParaPadraoIso8601(String data) throws IOException {
    DateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

    Date dataEntrada = null;
    try {
      dataEntrada = formatoEntrada.parse(data);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String dataConvertida = formatoSaida.format(dataEntrada);

    return dataConvertida;

  }

  private String formatarCpf(String cpf) {
    String cpfFormatado = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    return cpfFormatado;
  }
}
