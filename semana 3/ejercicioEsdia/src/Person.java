public class Person {
    
    //ATRIBUTOS
    String name = "noname"; //clases en mayúsculas
    float weightInKg;
    float heightInMeters;

    //CONSTRUCTORES
    //ctor explicito sin parametros
    public Person() {
        name ="NombrePorDefecto";
        weightInKg = 80.0f;
        heightInMeters = 1.8f;
    }

    public Person(String name, float weightInKg, float heightInMeters) { //Parametros de la funcion
        this.name = name; //Atributo
        this.weightInKg = weightInKg;
        this.heightInMeters = heightInMeters;
    }

}

//-ctor para constructor
//-sout para system.out.println