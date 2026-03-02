public class Biblioteca {
    private Libro[] catalogo;
    private final int CANT_LIBROS;

    public Biblioteca(int cantidad_maxima_libros) {
        CANT_LIBROS = cantidad_maxima_libros;
        catalogo = new Libro[CANT_LIBROS];

    }

    /**
     * Busca el primer libro que encuentre con el id recibido
     * @param idLibro
     * @return el libro encontrado
     */
    public Libro findLibro(int idLibro){
        boolean seguirBuscando = true;
        Libro libroEncontrado = null;

        for (int i = 0; i < CANT_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == idLibro) {
                seguirBuscando = false;
                libroEncontrado = catalogo[i];
            }
        }
        return libroEncontrado;
    }

    /**
     * metodo privado que busca la primera posicion libre en el array catalogo
     * @return - 1 si no hay hueco libre o la posicion libre
     */
    private int buscarPrimeroHuecoLibre(){
        int posicionLibre = -1;
        boolean seguirBuscando = true;

        for (int i = 0; i < CANT_LIBROS && seguirBuscando ; i++) {
            if(catalogo[i] == null){
                posicionLibre = i;
                seguirBuscando = false;
            }
        }
        return posicionLibre;
    }

    /**
     * Recibe y añade el libro no duplicado siempre que haya hueco
     * @param libro Libro recibido
     * @return true si se ha añadido y false si no ha podido añadirlo
     */
    public boolean addLibre(Libro libro){
        boolean libroAnadido = false;
        int posicion;
        posicion = buscarPrimeroHuecoLibre();

        // comprobamos si existe
            // buscar hueco
                // no hay -> libro Anadido = false
                // si hay ->
                // añadimos
                // LibroAnadido = true

        if(findLibro(libro.getId()) == null){ // no lo ha encontrado
            if(posicion >= 0 ){
                catalogo[posicion] = libro;
                libroAnadido = true;
            }
        }
        return libroAnadido;
    }

}
