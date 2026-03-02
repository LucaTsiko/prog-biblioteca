public class Main{
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(10);

        Libro libro1 = new Libro(1,"El Quijote","Miguel de Cervantes",67);
        Libro libro2 = new Libro(2,"El Gato Con Botas","Charles Perrault",67);

        System.out.println(biblioteca.findLibro(1));

        System.out.println(biblioteca.addLibro(libro1));
        System.out.println(biblioteca.addLibro(libro2));

        System.out.println(biblioteca.obtainCatalogo());
    }
}
