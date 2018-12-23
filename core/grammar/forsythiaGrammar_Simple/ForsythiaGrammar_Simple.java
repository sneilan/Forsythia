package org.fleen.forsythia.core.grammar.forsythiaGrammar_Simple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.fleen.forsythia.core.composition.FPolygon;
import org.fleen.forsythia.core.grammar.FMetagon;
import org.fleen.forsythia.core.grammar.ForsythiaGrammar;
import org.fleen.forsythia.core.grammar.Jig;
import org.fleen.geom_Kisrhombille.KMetagon;

/*
 * A simple forsythia grammar
 * By simple we mean that all the metagons and jigs are specified in the constructor
 * There is no intelligence here. Just storage.
 */
public class ForsythiaGrammar_Simple implements ForsythiaGrammar,Serializable{
  
  private static final long serialVersionUID=3018836034565752313L;

  /*
   * ################################
   * CONSTRUCTOR
   * init with a map of metagons and jig collections
   * ################################
   */
  
  public ForsythiaGrammar_Simple(Map<FMetagon,? extends Collection<Jig>> metagonjigs){
    Collection<Jig> c;
    for(FMetagon a:metagonjigs.keySet()){
      c=metagonjigs.get(a);
      this.metagonjigs.put(a,new JigList(c));}}
 
  /*
   * ################################
   * METAGONS AND JIGS
   * Implementation of ForsythiaGrammar interface
   * ################################
   */

  private Map<FMetagon,JigList> metagonjigs=new Hashtable<FMetagon,JigList>();
  
  public FMetagon getRandomMetagon(String[] tags){
    List<FMetagon> a=new ArrayList<FMetagon>();
    if(tags!=null&&tags.length!=0){
      for(FMetagon m:metagonjigs.keySet())
        if(m.hasTags(tags))
          a.add(m);
    }else{
      a.addAll(metagonjigs.keySet());}
    if(a.isEmpty())return null;
    Random random=new Random();
    FMetagon b=a.get(random.nextInt(a.size()));
    return b;}
  
  public Jig getRandomJig(FMetagon m,String[] tags,double detailfloor){
    Random random=new Random();//randomm was spitting out seros. Bug?
    //so we're instantiating it in method instead of class
    JigList a=metagonjigs.get(m);
    List<Jig> b=a.getJigsAboveFloorWithTags(tags,detailfloor);
    if(b.isEmpty())return null;
    Jig j=b.get(random.nextInt(b.size()));
    return j;}
  
  /*
   * ################################
   * MORE ACCESS METHODS
   * not part of ForsythiaGrammar interface
   * used in the grammar editor
   * ################################
   */
  
  /*
   * returns the map upon which this grammar is based
   * used for wrapping and extending, like with coneflower
   */
  public Map<FMetagon,JigList> getMetagonJigsMap(){
    return metagonjigs;}
  
  public int getMetagonCount(){
    return metagonjigs.keySet().size();}
  
  public Iterator<FMetagon> getMetagonIterator(){
    return metagonjigs.keySet().iterator();}
  
  public List<FMetagon> getMetagons(){
    List<FMetagon> m=new ArrayList<FMetagon>(metagonjigs.keySet());
    return m;}
  
  public List<Jig> getJigs(FMetagon metagon){
    List<Jig> a=new ArrayList<Jig>(metagonjigs.get(metagon));
    return a;}
  
  public List<Jig> getJigs(FPolygon polygon){
    List<Jig> a=new ArrayList<Jig>(metagonjigs.get(polygon.metagon));
    return a;}

  public List<Jig> getJigs(KMetagon kmetagon){
    FMetagon fm=null;
    SEEK:for(FMetagon sm:metagonjigs.keySet())
      if(sm.equals(kmetagon)){
        fm=sm;
        break SEEK;}
    if(fm==null)return new ArrayList<Jig>(0);
    return getJigs(fm);}
  
  /*
   * ################################
   * OBJECT
   * ################################
   */
  
  public String toString(){
    StringBuffer a=new StringBuffer();
    a.append("\n\n");
    a.append("#########################\n");
    a.append("### FORSYTHIA GRAMMAR ###\n\n");
    a.append("metagoncount="+metagonjigs.keySet().size()+"\n\n");
    JigList jiglist;
    for(FMetagon m:metagonjigs.keySet()){
      a.append("+++ METAGON +++\n");
      a.append(m.toString()+"\n");
      a.append("+++ JIGS +++\n");
      jiglist=metagonjigs.get(m);
      a.append("jigcount="+jiglist.size()+"\n");
      for(Jig jig:jiglist)
        a.append(jig.toString()+"\n");}
    a.append("### FORSYTHIA GRAMMAR ###\n");
    a.append("#########################\n");
    return a.toString();}
 
}