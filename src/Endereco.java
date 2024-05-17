public record Endereco(String cep, String logradouro,
                       String complemento, String localidade, String uf) {
    @Override
    public String toString() {
        return "Zip code: " + cep + ", Place: " + logradouro +
                ", Complement: " + complemento + ", City: " + localidade + ", UF: " + uf;
    }
}
