import java.util.ArrayList;

import com.promanager.promanager.Persistance.DAOtache;

public class gestionTache {
    private DAOtache tache;

    
    public gestionTache() {
    }

    public gestionTache(DAOtache tache) {
        this.tache = tache;
    }
    public ArrayList<Tache> getAll(){
        tache.getAll();
    }
    public Tache get(Integer index){
        return tache.get(index);
    }
    public Tache get(ObjectId id){
        return tache.get(id);
    }
    public void add(String categorie, String description, Date dateDepart, Date dateFinTache){
        tache.add(categorie,description,dateDepart,dateFinTache);
    }
    public void delete(ObjectId id,String key){
        tache.dalete(id,key);
    }
    public void delete(ObjectId id){
        tache.dalete(id);
    }
    public void update(ObjectId id, String key, Object value) {
        tache.update(id,key,value);
    }

    public void update(ObjectId id, String key, List<Object> value) {
        tache.update(id,key,value);
    }

    public void update(ObjectId id, HashMap<String, Object> Objects) {
        tache.update(id,Objects);
    }
}
