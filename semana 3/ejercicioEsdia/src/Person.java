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

    //LÓGICA O COMPORTAMIENTO (MÉTODOS) //funciones

    //Metodo para el calculo del IMC
    //
    public float obtainIMC(){

        return this.weightInKg/(this.heightInMeters*this.heightInMeters);
        //en el weight como no hay mas de dos se puede obviar el this
    }



    //GETTERS Y SETTERS
    //SE UTILIZAN CUANDO TIENES ATRIBUTOS PRIVADOS
    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name.isEmpty())
            return;

        this.name = name; //Son names distintos
    }

    public float getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(float weightInKg) {
        
        if(weightInKg<=0){ //Peso <0 retorna y no pasa
            return;
        }

        this.weightInKg = weightInKg;
    }

    public float getHeightInMeters() {
        return heightInMeters;
    }

    public void setHeightInMeters(float heightInMeters) {
        
        if(heightInMeters<=0){
            return;
        }

        this.heightInMeters = heightInMeters;
    }
}

//-ctor para constructor
//-sout para system.out.println