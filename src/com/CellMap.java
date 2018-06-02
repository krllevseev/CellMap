package com;

/**
 * Created by kirillevseev on 6/2/18.
 */

/** A CellMap is a collection of key/value Cell pairs.

 */

interface CellMap {



    /** a call to put() will add the input key/value pair to the collection.

     If the key has already been added to the collection, then the latest value will replace the existing value.

     A null "key" is not valid.  A null "value" will remove any existing key from the collection.

     Two keys are the same if key1.value.equals(key2.value).

     */

    void put( Cell key, Cell value );



    /** @return the "value" from a previous call of put(key,value).

    If the key is not part of the collection, then return null.

     */

    Cell get( Cell key );

}
