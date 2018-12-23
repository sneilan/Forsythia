package org.fleen.forsythia.coneflower;

import java.util.Map;

import org.fleen.forsythia.core.grammar.FMetagon;
import org.fleen.forsythia.core.grammar.ForsythiaGrammar;
import org.fleen.forsythia.core.grammar.Jig;
import org.fleen.forsythia.core.grammar.forsythiaGrammar_Simple.ForsythiaGrammar_Simple;
import org.fleen.forsythia.core.grammar.forsythiaGrammar_Simple.JigList;

public class Coneflower implements ForsythiaGrammar{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Coneflower(ForsythiaGrammar_Simple fgs){
    metagonjigs=fgs.getMetagonJigsMap();}

  /*
   * ################################
   * METAGON JIGS MAP
   * At init this gets passed from the ForsythiaGrammar_Simple
   * Also, when we create we generally cache too
   * so it expands
   * ################################
   */
  
  private Map<FMetagon,JigList> metagonjigs;
  
  /*
   * ################################
   * METAGONS ACCESS
   * ################################
   */
  
  @Override
  public FMetagon getRandomMetagon(String[] tags){
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * ################################
   * JIGS ACCESS
   * ################################
   */
  
  /*
   * A note on the gap param
   * Gap means an esthetically pleasing spacing
   * Gap can be used as detail floor. Thus describing a minimum detail size when selecting prospective jigs.
   * Gap can also be used as a span specification in boiling, describing the ideal span of the boil fat. 
   *   (And from that we might go doublewide, doubling the gap for another effect that kinda fits in with the undoubled gap) 
   * Gap can also be used as the spacing between polygons in a foam operation
   * These spacings are all related but not tightly interbound. Maybe not even constant.
   * So think about that. 
   * TODO maybe some renaming refactoring is called for. Or maybe a new param. Leave it for now.
   */
  public Jig getRandomJig(FMetagon m,String[] tags,double gap){
    // TODO Auto-generated method stub
    return null;
  }
  
  /*
   * ################################
   * BOIL
   * This is one of our algorithmically generated jig types
   * if we pass a "boil" tag to getRandomJig then 
   *   check metagonjigs to see if we have a suitable boil jig. if so return it
   *   otherwise try to create it here
   * ################################
   */

}