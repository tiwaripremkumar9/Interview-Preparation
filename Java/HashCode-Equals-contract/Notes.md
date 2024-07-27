# HashCode and equals Contract.

1. if two objects are equal, then the hashcode must return the same value.
2. Reverse may always not be true. if hashcode returns the same value for two objets, then it may be possible that the two objects are not same.
3. When hashcode is invoked on one object more than once than it should always 
return the same object.

if equals() return true then as per contract, ideally hashCode() for bioth object should also return the same integer.