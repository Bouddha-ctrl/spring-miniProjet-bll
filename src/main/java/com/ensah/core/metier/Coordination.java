/***********************************************************************
 * Module:  Coordination.java
 * Author:  Hp
 * Purpose: Defines the Class Coordination
 ***********************************************************************/
package com.ensah.core.metier;

import java.util.*;

/** @pdOid 63b5e40a-f00c-4d65-985a-c7e6dc8d7f28 */
public class Coordination {
   /** @pdOid 4cf91abd-9026-4c8c-a3cb-5ed9d48631a6 */
   private int idCoordination;
   /** @pdOid b5646649-9095-491f-8155-950a2b60a7d2 */
   private java.util.Date dateDebut;
   /** @pdOid 9f6c126f-07a8-4670-bd12-9e1340b1a5e3 */
   private java.util.Date dateFin;
   
   /** @pdRoleInfo migr=no name=Enseignant assc=Association_17 coll=java.util.Collection impl=java.util.HashSet mult=1..1 */
   public Enseignant coordonateur;

}