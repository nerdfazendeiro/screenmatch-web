package br.com.rafaelsilveiradev.services;

public interface IConverteDados {
  <T> T obterDados(String json, Class<T> classe);
}
