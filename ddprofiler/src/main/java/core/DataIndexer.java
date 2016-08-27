package core;

import java.util.Map;

import inputoutput.Attribute;
import preanalysis.Values;

public interface DataIndexer {

	public boolean indexData(Map<Attribute, Values> data, String sourceName);
	public boolean close();
	
}