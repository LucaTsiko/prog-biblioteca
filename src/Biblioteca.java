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
     * @return el libro encontrado o null si no lo encuentra
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

    /**
     * Recibe un id de un libro, lo borra y devuelve el libro eliminado o null si no lo encuentra
     * @param id Idenificador de libro
     * @return el libro eliminado o nll en caso de no encontrarlo
     */
    public Libro deleteLibro(int id){
        Libro libroEncontrado = null;
        boolean seguirBuscando = true;

        //comprobamos que existe. Necesitamos el libro y la posición

        for (int i = 0; i < CANT_LIBROS && seguirBuscando; i++) {
            if(catalogo[i] != null && catalogo[i].getId() == id){
                libroEncontrado = catalogo[i]; // guardo el libro
                catalogo[i] = null; // vacíamos la posición
                seguirBuscando = false; // para que no siga recorriendo
            }
        }
        return libroEncontrado;
    }

    /**
     * Actualiza el número de págnas del libro co el id recibido
     * @param idLibro id del libro a actualizar
     * @param numPaginas número de páginas actualizado
     * @return true si puede cambiarlo, false si no puede.
     */
    public boolean updateNumPaginas(int idLibro, int numPaginas){
        boolean numPaginasActualizado = false;

        Libro libro;

        libro = findLibro(idLibro);

        if(libro != null){
           numPaginasActualizado = libro.updateNumPaginas(numPaginas);
        }
        return numPaginasActualizado;
    }

    /**
     * Devuelve un String con el catálodo de libros
     * @return String con el catálogo de libros
     */
    public String obtainCatalodo(){
        StringBuilder sb = new StringBuilder("Catalogo: { ");

        for (int i = 0; i < CANT_LIBROS; i++) {
            if(catalogo[i] != null){
                sb.append(catalogo[i].toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
