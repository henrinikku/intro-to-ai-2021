package iai.nlp;

public class Relation {
    
    private final String argument1, relation, argument2;
    
    public Relation(String argument1, String relation, String argument2) {
        this.argument1 = argument1;
        this.relation = relation;
        this.argument2 = argument2;
    }
    
    public String getArgument1() {
        return this.argument1;
    }
    
    public String getRelation() {
        return this.relation;
    }
    
    public String getArgument2() {
        return this.argument2;
    }
    
}
