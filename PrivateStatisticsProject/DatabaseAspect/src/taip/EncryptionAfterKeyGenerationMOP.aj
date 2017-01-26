package taip;
import java.io.*;
import java.util.*;
import utilitiesModule.java.Paillier;
import javamoprt.*;
import java.lang.ref.*;
import org.aspectj.lang.*;

class EncryptionAfterKeyGenerationMonitor_Set extends javamoprt.MOPSet {
	protected EncryptionAfterKeyGenerationMonitor[] elementData;

	public EncryptionAfterKeyGenerationMonitor_Set(){
		this.size = 0;
		this.elementData = new EncryptionAfterKeyGenerationMonitor[4];
	}

	public final int size(){
		while(size > 0 && elementData[size-1].MOP_terminated) {
			elementData[--size] = null;
		}
		return size;
	}

	public final boolean add(MOPMonitor e){
		ensureCapacity();
		elementData[size++] = (EncryptionAfterKeyGenerationMonitor)e;
		return true;
	}

	public final void endObject(int idnum){
		int numAlive = 0;
		for(int i = 0; i < size; i++){
			EncryptionAfterKeyGenerationMonitor monitor = elementData[i];
			if(!monitor.MOP_terminated){
				monitor.endObject(idnum);
			}
			if(!monitor.MOP_terminated){
				elementData[numAlive++] = monitor;
			}
		}
		for(int i = numAlive; i < size; i++){
			elementData[i] = null;
		}
		size = numAlive;
	}

	public final boolean alive(){
		for(int i = 0; i < size; i++){
			MOPMonitor monitor = elementData[i];
			if(!monitor.MOP_terminated){
				return true;
			}
		}
		return false;
	}

	public final void endObjectAndClean(int idnum){
		int size = this.size;
		this.size = 0;
		for(int i = size - 1; i >= 0; i--){
			MOPMonitor monitor = elementData[i];
			if(monitor != null && !monitor.MOP_terminated){
				monitor.endObject(idnum);
			}
			elementData[i] = null;
		}
		elementData = null;
	}

	public final void ensureCapacity() {
		int oldCapacity = elementData.length;
		if (size + 1 > oldCapacity) {
			cleanup();
		}
		if (size + 1 > oldCapacity) {
			EncryptionAfterKeyGenerationMonitor[] oldData = elementData;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < size + 1){
				newCapacity = size + 1;
			}
			elementData = Arrays.copyOf(oldData, newCapacity);
		}
	}

	public final void cleanup() {
		int numAlive = 0 ;
		for(int i = 0; i < size; i++){
			EncryptionAfterKeyGenerationMonitor monitor = (EncryptionAfterKeyGenerationMonitor)elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;
			}
		}
		for(int i = numAlive; i < size; i++){
			elementData[i] = null;
		}
		size = numAlive;
	}

	public final void event_constructor(Paillier p) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EncryptionAfterKeyGenerationMonitor monitor = (EncryptionAfterKeyGenerationMonitor)this.elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;

				monitor.Prop_1_event_constructor(p);
				if(monitor.Prop_1_Category_fail) {
					monitor.Prop_1_handler_fail(p);
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elementData[i] = null;
		}
		size = numAlive;
	}

	public final void event_keyGeneration(Paillier p) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EncryptionAfterKeyGenerationMonitor monitor = (EncryptionAfterKeyGenerationMonitor)this.elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;

				monitor.Prop_1_event_keyGeneration(p);
				if(monitor.Prop_1_Category_fail) {
					monitor.Prop_1_handler_fail(p);
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elementData[i] = null;
		}
		size = numAlive;
	}

	public final void event_encryption(Paillier p) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EncryptionAfterKeyGenerationMonitor monitor = (EncryptionAfterKeyGenerationMonitor)this.elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;

				monitor.Prop_1_event_encryption(p);
				if(monitor.Prop_1_Category_fail) {
					monitor.Prop_1_handler_fail(p);
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elementData[i] = null;
		}
		size = numAlive;
	}
}

class EncryptionAfterKeyGenerationMonitor extends javamoprt.MOPMonitor implements Cloneable, javamoprt.MOPObject {
	public Object clone() {
		try {
			EncryptionAfterKeyGenerationMonitor ret = (EncryptionAfterKeyGenerationMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	MOPIntSpliceList Prop_1_l;

	static MOPPMATransitionImpl [][] Prop_1_pma = {
		{
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(3)),
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(1)),
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(7, 0)),
		},

		{
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(2, new int[] {})),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(0)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(0)),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(3)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(3)),
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(8, new int[] {})),
		},

		{
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(5, new int[] {0,})),
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(4, 0)),
			new MOPPMATransitionImpl(0, new MOPPMAStateImpl(6, new int[] {})),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(1)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(1)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(1)),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(3)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(3)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(3)),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(7, 0)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(7, 0)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(7, 0)),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(0)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(0)),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(0)),
		},

		{
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(6, new int[] {})),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(6, new int[] {})),
			new MOPPMATransitionImpl(1, new MOPPMAStateImpl(6, new int[] {})),
		},

	};
	static private int rewrite(MOPIntSpliceList l){
		if(l.isEmpty()) return -1;
		MOPSLIntIterator first;
		MOPSLIntIterator second;
		MOPSLIntIterator lastRepl = null;
		int currentState;
		MOPPMATransitionImpl trans;
		int symbol;
		boolean changed;
		boolean atOrPastLastChange;
		do {
			currentState = 0;
			atOrPastLastChange = false;
			changed = false;
			first = l.head();
			second = l.head();
			symbol = second.get();
			while(true){
				trans = Prop_1_pma[currentState][symbol];
				if(currentState == 0 && trans.state.number == 0){
					if(!first.next()) break;
				}
				else {
					first.next(trans.action);
				}
				if(trans.state.category == 0){
					return 0;
				}
				if(trans.state.category == 1){
					return 1;
				}
				if(trans.state.replacement != null){
					first.nonDestructiveSplice(second, trans.state.replacement);
					if(l.isEmpty()) return -1;
					changed = true;
					atOrPastLastChange = false;
					lastRepl = second;
					second = first.copy();
					currentState = 0;
					symbol = second.get();
					if(symbol == -1) break;
					continue;
				}
				currentState = trans.state.number;
				//normal transition
				if(trans.action == 0){
					if(!second.next()) break;
					if(!changed){
						if(second.equals(lastRepl)){
							atOrPastLastChange = true;
						}
						if(atOrPastLastChange && currentState == 0){
							return -1;
						}
					}
					symbol = second.get();
				}
				//fail transition, need to reconsider he same symbol in next state
			}
		} while(changed);
		return -1;
	}

	boolean Prop_1_Category_fail = false;

	public EncryptionAfterKeyGenerationMonitor () {
		Prop_1_l = new MOPIntSpliceList();

	}

	public final void Prop_1_event_constructor(Paillier p) {
		MOP_lastevent = 0;

		Prop_1_l.add(1);
		int out = rewrite(Prop_1_l);
		Prop_1_Category_fail = out == 0;
	}

	public final void Prop_1_event_keyGeneration(Paillier p) {
		MOP_lastevent = 1;

		Prop_1_l.add(0);
		int out = rewrite(Prop_1_l);
		Prop_1_Category_fail = out == 0;
	}

	public final void Prop_1_event_encryption(Paillier p) {
		MOP_lastevent = 2;

		Prop_1_l.add(2);
		int out = rewrite(Prop_1_l);
		Prop_1_Category_fail = out == 0;
	}

	public final void Prop_1_handler_fail (Paillier p){
		{
			System.out.println("Call order of methods is wrong!");
		}

	}

	public final void reset() {
		MOP_lastevent = -1;
		Prop_1_l = new MOPIntSpliceList();
		Prop_1_Category_fail = false;
	}

	public javamoprt.ref.MOPWeakReference MOPRef_p;

	public final void endObject(int idnum){
		switch(idnum){
			case 0:
			break;
		}
		switch(MOP_lastevent) {
			case -1:
			return;
			case 0:
			//constructor
			return;
			case 1:
			//keyGeneration
			return;
			case 2:
			//encryption
			return;
		}
		return;
	}

}

public aspect HasNextMonitorAspect implements javamoprt.MOPObject {
	javamoprt.map.MOPMapManager HasNextMapManager;
	public HasNextMonitorAspect(){
		HasNextMapManager = new javamoprt.map.MOPMapManager();
		HasNextMapManager.start();
	}

	// Declarations for the Lock
	static Object HasNext_MOPLock = new Object();

	static boolean EncryptionAfterKeyGeneration_activated = false;

	// Declarations for Indexing Trees
	static javamoprt.map.MOPBasicRefMapOfMonitor EncryptionAfterKeyGeneration_p_Map = new javamoprt.map.MOPBasicRefMapOfMonitor(0);
	static javamoprt.ref.MOPWeakReference EncryptionAfterKeyGeneration_p_Map_cachekey_0 = javamoprt.map.MOPBasicRefMapOfMonitor.NULRef;
	static EncryptionAfterKeyGenerationMonitor EncryptionAfterKeyGeneration_p_Map_cachenode = null;

	// Trees for References
	static javamoprt.map.MOPRefMap HasNext_Paillier_RefMap = EncryptionAfterKeyGeneration_p_Map;

	pointcut MOP_CommonPointCut() : !within(javamoprt.MOPObject+) && !adviceexecution();
	pointcut EncryptionAfterKeyGeneration_constructor(Paillier p) : (call(* Paillier.Paillier(..)) && target(p)) && MOP_CommonPointCut();
	after (Paillier p) : EncryptionAfterKeyGeneration_constructor(p) {
		EncryptionAfterKeyGeneration_activated = true;
		synchronized(HasNext_MOPLock) {
			EncryptionAfterKeyGenerationMonitor mainMonitor = null;
			javamoprt.map.MOPMap mainMap = null;
			javamoprt.ref.MOPWeakReference TempRef_p;

			// Cache Retrieval
			if (p == EncryptionAfterKeyGeneration_p_Map_cachekey_0.get()) {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map_cachekey_0;

				mainMonitor = EncryptionAfterKeyGeneration_p_Map_cachenode;
			} else {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map.getRef(p);
			}

			if (mainMonitor == null) {
				mainMap = EncryptionAfterKeyGeneration_p_Map;
				mainMonitor = (EncryptionAfterKeyGenerationMonitor)mainMap.getNode(TempRef_p);

				if (mainMonitor == null) {
					mainMonitor = new EncryptionAfterKeyGenerationMonitor();

					mainMonitor.MOPRef_p = TempRef_p;

					EncryptionAfterKeyGeneration_p_Map.putNode(TempRef_p, mainMonitor);
				}

				EncryptionAfterKeyGeneration_p_Map_cachekey_0 = TempRef_p;
				EncryptionAfterKeyGeneration_p_Map_cachenode = mainMonitor;
			}

			mainMonitor.Prop_1_event_constructor(p);
			if(mainMonitor.Prop_1_Category_fail) {
				mainMonitor.Prop_1_handler_fail(p);
			}
		}
	}

	pointcut EncryptionAfterKeyGeneration_keyGeneration(Paillier p) : (call(* Paillier.KeyGeneration(..)) && target(p)) && MOP_CommonPointCut();
	after (Paillier p) : EncryptionAfterKeyGeneration_keyGeneration(p) {
		EncryptionAfterKeyGeneration_activated = true;
		synchronized(HasNext_MOPLock) {
			EncryptionAfterKeyGenerationMonitor mainMonitor = null;
			javamoprt.map.MOPMap mainMap = null;
			javamoprt.ref.MOPWeakReference TempRef_p;

			// Cache Retrieval
			if (p == EncryptionAfterKeyGeneration_p_Map_cachekey_0.get()) {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map_cachekey_0;

				mainMonitor = EncryptionAfterKeyGeneration_p_Map_cachenode;
			} else {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map.getRef(p);
			}

			if (mainMonitor == null) {
				mainMap = EncryptionAfterKeyGeneration_p_Map;
				mainMonitor = (EncryptionAfterKeyGenerationMonitor)mainMap.getNode(TempRef_p);

				if (mainMonitor == null) {
					mainMonitor = new EncryptionAfterKeyGenerationMonitor();

					mainMonitor.MOPRef_p = TempRef_p;

					EncryptionAfterKeyGeneration_p_Map.putNode(TempRef_p, mainMonitor);
				}

				EncryptionAfterKeyGeneration_p_Map_cachekey_0 = TempRef_p;
				EncryptionAfterKeyGeneration_p_Map_cachenode = mainMonitor;
			}

			mainMonitor.Prop_1_event_keyGeneration(p);
			if(mainMonitor.Prop_1_Category_fail) {
				mainMonitor.Prop_1_handler_fail(p);
			}
		}
	}

	pointcut EncryptionAfterKeyGeneration_encryption(Paillier p) : (call(* Paillier.Encryption(..)) && target(p)) && MOP_CommonPointCut();
	before (Paillier p) : EncryptionAfterKeyGeneration_encryption(p) {
		EncryptionAfterKeyGeneration_activated = true;
		synchronized(HasNext_MOPLock) {
			EncryptionAfterKeyGenerationMonitor mainMonitor = null;
			javamoprt.map.MOPMap mainMap = null;
			javamoprt.ref.MOPWeakReference TempRef_p;

			// Cache Retrieval
			if (p == EncryptionAfterKeyGeneration_p_Map_cachekey_0.get()) {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map_cachekey_0;

				mainMonitor = EncryptionAfterKeyGeneration_p_Map_cachenode;
			} else {
				TempRef_p = EncryptionAfterKeyGeneration_p_Map.getRef(p);
			}

			if (mainMonitor == null) {
				mainMap = EncryptionAfterKeyGeneration_p_Map;
				mainMonitor = (EncryptionAfterKeyGenerationMonitor)mainMap.getNode(TempRef_p);

				if (mainMonitor == null) {
					mainMonitor = new EncryptionAfterKeyGenerationMonitor();

					mainMonitor.MOPRef_p = TempRef_p;

					EncryptionAfterKeyGeneration_p_Map.putNode(TempRef_p, mainMonitor);
				}

				EncryptionAfterKeyGeneration_p_Map_cachekey_0 = TempRef_p;
				EncryptionAfterKeyGeneration_p_Map_cachenode = mainMonitor;
			}

			mainMonitor.Prop_1_event_encryption(p);
			if(mainMonitor.Prop_1_Category_fail) {
				mainMonitor.Prop_1_handler_fail(p);
			}
		}
	}

}
