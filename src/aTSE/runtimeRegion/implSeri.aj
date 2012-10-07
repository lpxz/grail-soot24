package aTSE.runtimeRegion;
import java.io.Serializable;;
public aspect implSeri {
	declare parents : soot..* implements Serializable;

}
