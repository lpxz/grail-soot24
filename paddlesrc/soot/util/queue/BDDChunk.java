package soot.util.queue;

class BDDChunk {
    final jedd.internal.RelationContainer bdd =
      new jedd.internal.RelationContainer(new jedd.Attribute[] {  }, new jedd.PhysicalDomain[] {  },
                                          ("<> bdd = jedd.internal.Jedd.v().falseBDD() at BDDChunk.jedd:" + "34,4-6"),
                                          jedd.internal.Jedd.v().falseBDD());
    
    BDDChunk next;
    
    public BDDChunk() { super(); }
}
