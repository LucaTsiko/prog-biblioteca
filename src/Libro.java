public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;

    /**
     * Metodo constructor de Libros
     * @param id identificador del libro
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param numPaginas número de páginas del libro
     */
    public Libro(int id, String titulo, String autor, int numPaginas){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    /**
     * Devuelve el id del libro
     * @return id del libro
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el titulo del libro
     * @return titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Libro: { ");
        sb.append(String.format("\n id: %d; ", id));
        sb.append(String.format("titulo: %s; ", titulo));
        sb.append(String.format("autor: %s; ", autor));
        sb.append(String.format("numPaginas: %d; ", numPaginas));
        sb.append("}");

        return sb.toString();
    }
}
