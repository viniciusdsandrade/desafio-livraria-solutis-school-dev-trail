package entity;

import java.sql.*;

import static config.MySQLConnection.getConnection;

public class Eletronico extends Livro {

    private long tamanho;

    public Eletronico(String titulo,
                      String autores,
                      String editora,
                      double preco,
                      long tamanho) {
        super(titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    public Eletronico(int id,
                      String titulo,
                      String autores,
                      String editora,
                      double preco,
                      long tamanho) {
        super(id, titulo, autores, editora, preco);
        this.tamanho = tamanho;
    }

    @Override
    protected String getTipo() {
        return "ELETRONICO";
    }

    @Override
    public void saveSpecificDetails() throws SQLException {
        Connection conn = getConnection();
        String sql = "INSERT INTO eletronico (id, tamanho) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setDouble(2, tamanho);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public double getTamanho() {
        return tamanho;
    }
    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Título: %s, Autores: %s, Editora: %s, Preço: %.2f, Tamanho: %d KB",
                id, titulo, autores, editora, preco, tamanho
        );
    }
}
