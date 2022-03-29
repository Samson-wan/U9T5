import java.lang.reflect.Array;
import java.util.ArrayList;
public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name){
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public String getName() {
        return name;
    }

    public boolean addPerformer(Performer person){
        if(performers.indexOf(person) == -1){
            performers.add(person);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removePerformer(Performer person){
        for(int i = 0; i < performers.size(); i++){
            if(person.getName().equals(performers.get(i).getName())){
                performers.remove(i);
                return true;
            }
        }
        return false;
    }

    public double averagePerformerAge(){
        double total = 0;
        for(Performer person : performers){
            total += person.getAge();
        }
        return total / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age){
        ArrayList<Performer> list = new ArrayList<Performer>();
        for(Performer person : performers){
            if(person.getAge() >= age){
                list.add(person);
            }
        }
        return list;
    }

    public void groupRehearsal(){
        for(Performer person : performers){
            if(person instanceof Performer || person instanceof Dancer){
                System.out.println("REHERSAL CALL! " + person.getName());
                person.rehearse();
            }
            else if(person instanceof Comedian){
                System.out.println("REHERSAL CALL! " + person.getName());
                ((Comedian)person).rehearse(false);
            }
        }
    }

    public void cabaretShow(){
        for(Performer person : performers){
            System.out.println("Welcome to the cabaret! Next act up… " + person.getName());
            if(person instanceof Dancer){
                ((Dancer)person).pirouette(2);
            }
            person.perform();
        }
    }
}
