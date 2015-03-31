package models;

public enum Tag {

    Alternative("Alternative"),
    Blues("Blues"),
    Classique("Classique"),
    Dance("Dance"),
    Electro("Electro"),
    FilmsEtJeux("Films et Jeux"),
    France("France"),
    HipHop("Hip Hop"),
    Jazz("Jazz"),
    Enfant("Enfant"),
    Pop("Pop"),
    RandBSoulFunk("R&B, Soul, Funk"),
    Reggae("Reggae"),
    Rock("Rock"),
    World("World");
    
    private String name;
    
    Tag(String name){
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
    
}
