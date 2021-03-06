package taip;
import java.io.*;
import java.util.*;
import javamoprt.*;
import java.lang.ref.*;
import org.aspectj.lang.*;

class CreateUSERMonitor_Set extends javamoprt.MOPSet {
	protected CreateUSERMonitor[] elementData;

	public CreateUSERMonitor_Set(){
		this.size = 0;
		this.elementData = new CreateUSERMonitor[4];
	}

	public final int size(){
		while(size > 0 && elementData[size-1].MOP_terminated) {
			elementData[--size] = null;
		}
		return size;
	}

	public final boolean add(MOPMonitor e){
		ensureCapacity();
		elementData[size++] = (CreateUSERMonitor)e;
		return true;
	}

	public final void endObject(int idnum){
		int numAlive = 0;
		for(int i = 0; i < size; i++){
			CreateUSERMonitor monitor = elementData[i];
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
			CreateUSERMonitor[] oldData = elementData;
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
			CreateUSERMonitor monitor = (CreateUSERMonitor)elementData[i];
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

	public final void event_connectionDB() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CreateUSERMonitor monitor = (CreateUSERMonitor)this.elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;

				monitor.Prop_1_event_connectionDB();
				if(monitor.Prop_1_Category_match) {
					monitor.Prop_1_handler_match(null, null, null);
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elementData[i] = null;
		}
		size = numAlive;
	}

	public final void event_addUSER(String name, BigInteger age, String userType) {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			CreateUSERMonitor monitor = (CreateUSERMonitor)this.elementData[i];
			if(!monitor.MOP_terminated){
				elementData[numAlive] = monitor;
				numAlive++;

				monitor.Prop_1_event_addUSER(name, age, userType);
				if(monitor.Prop_1_Category_match) {
					monitor.Prop_1_handler_match(name, age, userType);
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elementData[i] = null;
		}
		size = numAlive;
	}
}

class CreateUSERMonitor extends javamoprt.MOPMonitor implements Cloneable, javamoprt.MOPObject {
	public long tau = -1;
	public Object clone() {
		try {
			CreateUSERMonitor ret = (CreateUSERMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	int Prop_1_state;
	static final int Prop_1_transition_connectionDB[] = {1, 3, 3, 3};;
	static final int Prop_1_transition_addUSER[] = {3, 2, 3, 3};;

	boolean Prop_1_Category_match = false;

	public CreateUSERMonitor () {
		Prop_1_state = 0;

	}

	public final void Prop_1_event_connectionDB() {
		MOP_lastevent = 0;

		Prop_1_state = Prop_1_transition_connectionDB[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	public final void Prop_1_event_addUSER(String name, BigInteger age, String userType) {
		MOP_lastevent = 1;

		Prop_1_state = Prop_1_transition_addUSER[Prop_1_state];
		Prop_1_Category_match = Prop_1_state == 2;
	}

	public final void Prop_1_handler_match (String name, BigInteger age, String userType){
		{
			System.out.println("User was registered without a connectionDB before ");
		}

	}

	public final void reset() {
		MOP_lastevent = -1;
		Prop_1_state = 0;
		Prop_1_Category_match = false;
	}

	public javamoprt.ref.MOPMultiTagWeakReference MOPRef_name;
	public javamoprt.ref.MOPTagWeakReference MOPRef_age;
	public javamoprt.ref.MOPMultiTagWeakReference MOPRef_userType;

	//alive_parameters_0 = [String name, BigInteger age, String userType]
	public boolean alive_parameters_0 = true;

	public final void endObject(int idnum){
		switch(idnum){
			case 0:
			alive_parameters_0 = false;
			break;
			case 1:
			alive_parameters_0 = false;
			break;
			case 2:
			alive_parameters_0 = false;
			break;
		}
		switch(MOP_lastevent) {
			case -1:
			return;
			case 0:
			//connectionDB
			//alive_name && alive_age && alive_userType
			if(!(alive_parameters_0)){
				MOP_terminated = true;
				return;
			}
			break;

			case 1:
			//addUSER
			return;
		}
		return;
	}

}

public aspect SafeSyncMapMonitorAspect implements javamoprt.MOPObject {
	javamoprt.map.MOPMapManager SafeSyncMapMapManager;
	public SafeSyncMapMonitorAspect(){
		SafeSyncMapMapManager = new javamoprt.map.MOPMapManager();
		SafeSyncMapMapManager.start();
	}

	// Declarations for the Lock
	static Object SafeSyncMap_MOPLock = new Object();

	// Declarations for Timestamps
	static long CreateUSER_timestamp = 1;

	static boolean CreateUSER_activated = false;

	// Declarations for Indexing Trees
	static CreateUSERMonitor_Set CreateUSER_Set = new CreateUSERMonitor_Set();
	static CreateUSERMonitor CreateUSER_Monitor = null;
	static javamoprt.map.MOPAbstractMap CreateUSER_name_age_userType_Map = new javamoprt.map.MOPMapOfAll(0);
	static javamoprt.ref.MOPMultiTagWeakReference CreateUSER_name_age_userType_Map_cachekey_0 = javamoprt.map.MOPMultiTagRefMap.NULRef;
	static javamoprt.ref.MOPTagWeakReference CreateUSER_name_age_userType_Map_cachekey_1 = javamoprt.map.MOPTagRefMap.NULRef;
	static javamoprt.ref.MOPMultiTagWeakReference CreateUSER_name_age_userType_Map_cachekey_2 = javamoprt.map.MOPMultiTagRefMap.NULRef;
	static CreateUSERMonitor CreateUSER_name_age_userType_Map_cachenode = null;

	// Trees for References
	static javamoprt.map.MOPRefMap SafeSyncMap_String_RefMap = new javamoprt.map.MOPMultiTagRefMap(2);
	static javamoprt.map.MOPRefMap SafeSyncMap_BigInteger_RefMap = new javamoprt.map.MOPTagRefMap();

	pointcut MOP_CommonPointCut() : !within(javamoprt.MOPObject+) && !adviceexecution();
	pointcut CreateUSER_connectionDB() : (call(* MySQLConnectionDB.getConnection())) && MOP_CommonPointCut();
	before () : CreateUSER_connectionDB() {
		CreateUSER_activated = true;
		synchronized(SafeSyncMap_MOPLock) {
			CreateUSERMonitor mainMonitor = null;
			CreateUSERMonitor_Set mainSet = null;

			mainSet = CreateUSER_Set;
			mainMonitor = CreateUSER_Monitor;

			if (mainMonitor == null) {
				mainMonitor = new CreateUSERMonitor();

				CreateUSER_Monitor = mainMonitor;
				CreateUSER_Set.add(mainMonitor);
				mainMonitor.tau = CreateUSER_timestamp;
				CreateUSER_timestamp++;
			}

			if(mainSet != null) {
				mainSet.event_connectionDB();
			}
		}
	}

	pointcut CreateUSER_addUSER(String name, BigInteger age, String userType) : (call(* MySQLConnectionDB.insertSecurePatient(..))) && MOP_CommonPointCut();
	after (String name, BigInteger age, String userType) : CreateUSER_addUSER(name, age, userType) {
		CreateUSER_activated = true;
		synchronized(SafeSyncMap_MOPLock) {
			Object obj;
			javamoprt.map.MOPMap tempMap;
			CreateUSERMonitor mainMonitor = null;
			CreateUSERMonitor origMonitor = null;
			javamoprt.map.MOPMap mainMap = null;
			javamoprt.ref.MOPMultiTagWeakReference TempRef_name;
			javamoprt.ref.MOPTagWeakReference TempRef_age;
			javamoprt.ref.MOPMultiTagWeakReference TempRef_userType;

			// Cache Retrieval
			if (name == CreateUSER_name_age_userType_Map_cachekey_0.get() && age == CreateUSER_name_age_userType_Map_cachekey_1.get() && userType == CreateUSER_name_age_userType_Map_cachekey_2.get()) {
				TempRef_name = CreateUSER_name_age_userType_Map_cachekey_0;
				TempRef_age = CreateUSER_name_age_userType_Map_cachekey_1;
				TempRef_userType = CreateUSER_name_age_userType_Map_cachekey_2;

				mainMonitor = CreateUSER_name_age_userType_Map_cachenode;
			} else {
				TempRef_name = SafeSyncMap_String_RefMap.getMultiTagRef(name, thisJoinPoint.getStaticPart().getId());
				TempRef_age = SafeSyncMap_BigInteger_RefMap.getTagRef(age);
				TempRef_userType = SafeSyncMap_String_RefMap.getMultiTagRef(userType, thisJoinPoint.getStaticPart().getId());
			}

			if (mainMonitor == null) {
				tempMap = CreateUSER_name_age_userType_Map;
				obj = tempMap.getMap(TempRef_name);
				if (obj == null) {
					obj = new javamoprt.map.MOPMapOfAll(1);
					tempMap.putMap(TempRef_name, obj);
				}
				tempMap = (javamoprt.map.MOPAbstractMap)obj;
				obj = tempMap.getMap(TempRef_age);
				if (obj == null) {
					obj = new javamoprt.map.MOPMapOfMonitor(2);
					tempMap.putMap(TempRef_age, obj);
				}
				mainMap = (javamoprt.map.MOPAbstractMap)obj;
				mainMonitor = (CreateUSERMonitor)mainMap.getNode(TempRef_userType);

				if (mainMonitor == null) {
					if (mainMonitor == null) {
						origMonitor = CreateUSER_Monitor;
						if (origMonitor != null) {
							boolean timeCheck = true;

							if (TempRef_name.disable[0] > origMonitor.tau) {
								timeCheck = false;
							}
							if (TempRef_age.disable > origMonitor.tau) {
								timeCheck = false;
							}
							if (TempRef_userType.disable[0] > origMonitor.tau) {
								timeCheck = false;
							}

							if (timeCheck) {
								mainMonitor = (CreateUSERMonitor)origMonitor.clone();
								mainMonitor.MOPRef_name = TempRef_name;
								if (TempRef_name.tau[0] == -1){
									TempRef_name.tau[0] = origMonitor.tau;
								}
								mainMonitor.MOPRef_age = TempRef_age;
								if (TempRef_age.tau == -1){
									TempRef_age.tau = origMonitor.tau;
								}
								mainMonitor.MOPRef_userType = TempRef_userType;
								if (TempRef_userType.tau[0] == -1){
									TempRef_userType.tau[0] = origMonitor.tau;
								}
								mainMap.putNode(TempRef_userType, mainMonitor);

								CreateUSER_Set.add(mainMonitor);
							}
						}
					}
					if (mainMonitor == null) {
						mainMonitor = new CreateUSERMonitor();

						mainMonitor.MOPRef_name = TempRef_name;
						mainMonitor.MOPRef_age = TempRef_age;
						mainMonitor.MOPRef_userType = TempRef_userType;

						mainMap.putNode(TempRef_userType, mainMonitor);
						mainMonitor.tau = CreateUSER_timestamp;
						if (TempRef_name.tau[0] == -1){
							TempRef_name.tau[0] = CreateUSER_timestamp;
						}
						if (TempRef_age.tau == -1){
							TempRef_age.tau = CreateUSER_timestamp;
						}
						if (TempRef_userType.tau[0] == -1){
							TempRef_userType.tau[0] = CreateUSER_timestamp;
						}
						CreateUSER_timestamp++;

						CreateUSER_Set.add(mainMonitor);
					}

					TempRef_name.disable[0] = CreateUSER_timestamp;
					TempRef_age.disable = CreateUSER_timestamp;
					TempRef_userType.disable[0] = CreateUSER_timestamp;
					CreateUSER_timestamp++;
				}

				CreateUSER_name_age_userType_Map_cachekey_0 = TempRef_name;
				CreateUSER_name_age_userType_Map_cachekey_1 = TempRef_age;
				CreateUSER_name_age_userType_Map_cachekey_2 = TempRef_userType;
				CreateUSER_name_age_userType_Map_cachenode = mainMonitor;
			}

			mainMonitor.Prop_1_event_addUSER(name, age, userType);
			if(mainMonitor.Prop_1_Category_match) {
				mainMonitor.Prop_1_handler_match(name, age, userType);
			}
		}
	}

}
