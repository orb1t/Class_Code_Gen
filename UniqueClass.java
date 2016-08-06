/*DDCs*/
import java.util.*;

public final class UniqueClass
{
   private String name;
   
   private ArrayList<Map<String, String>> instVars;
   private ArrayList<Map<String, String>> setMethods;
   private ArrayList<Map<String, String>> getMethods;
   private ArrayList<Map<String, String>> specialMethods;

   public static final int MAX_AMT = 100, MIN_AMT = 0;
   /*max # of  instance vars for this unique class*/
   private int amtInstVars;
   
   /*max # of methods for setMethods, getMethods, and specialMethods*/
   private int amtMethods;

   /*used for radio buttons*/
   private boolean isAbstractClass;
   private boolean hasSuper;
   private boolean isDataDefining;
   /*private boolean hasSubTypes;*/
   private boolean hasConsts;
   private boolean hasToString;
   private boolean isFinal;
   
   private static int count = 0;
   
   /**
      Default constructor for counting
   */
   private UniqueClass(){this.count++;}
   
   /*chaining of constructors to make a fully loaded new instance */
   private UniqueClass(String someName)
   {
      this();
      this.name = someName;
   }
   
   private UniqueClass(String someName, boolean isAbstract)
   {
      this(someName);
      this.isAbstractClass = isAbstract;
   }
   
   private UniqueClass(String someName, boolean isAbstract, boolean hasParent)
   {
      this(someName, isAbstract);
      this.hasSuper = hasParent;
      
   }
   
   private UniqueClass(String someName, boolean isAbstract, boolean hasParent, boolean definesData)
   {
      this(someName, isAbstract, hasParent);
      this.isDataDefining = definesData;
   }
   
   private UniqueClass(String someName, boolean isAbstract, boolean hasParent, boolean definesData, boolean hasKids)
   {
      this(someName, isAbstract, hasParent, definesData);
      this.hasSubTypes = hasKids;
   }
   
   private UniqueClass(String someName, boolean isAbstract, boolean hasParent, boolean definesData, boolean hasKids, boolean hasConstants)
   {
      this(someName, isAbstract, hasParent, definesData, hasKids);
      this.hasConsts = hasConstants;
   }
   
   private UniqueClass(String someName, boolean isAbstract, boolean hasParent, boolean definesData, boolean hasKids, boolean hasConstants, boolean needsToString)
   {
      this(someName, isAbstract, hasParent, definesData, hasKids, hasConstants);
      this.hasToString = needsToString;
   }
   
   public UniqueClass(String someName, boolean isAbstract, boolean hasParent, boolean definesData, boolean hasKids, boolean hasConstants, boolean needsToString,
      boolean isSubClassed)
   {
      this(someName, isAbstract, hasParent, definesData, hasKids, hasConstants, needsToString);
      
      this.instVars = new ArrayList<>(MIN_AMT);
      this.setMethods = new ArrayList<>(MIN_AMT);
      this.getMethods = new ArrayList<>(MIN_AMT);
      this.specialMethods = new ArrayList<>(MIN_AMT);
      this.amtMethods = 0;
   }
   
   /**
      sets the # of methods for the specified class
   */
   public boolean setMethodAmt(int newAmt)
   {
      if(newAmt < MIN_AMT || newAmt > MAX_AMT)
      {throw new IllegalArgumentException("<the new amount of methods is invalid>");}
      else
      {
         this.amtMethods = newAmt;
         return true;
      }
   }
   
   /**
      @return this.amtMethods - the given max for the number of methods possible
   */
   public int getMethodRelativeMax(){return this.amtMethods;}
}
