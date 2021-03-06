package core.tasks;

import core.SourceType;
import core.config.sources.CSVSourceConfig;
import core.config.sources.SourceConfig;
import inputoutput.connectors.CSVConnector;
import inputoutput.connectors.Connector;

public class CSVProfileTask implements ProfileTask {

    private int taskId;
    // private Old_Connector connector;
    private CSVConnector connector;
    private CSVSourceConfig config;

    public CSVProfileTask(CSVSourceConfig conf) {
	this.config = conf;
	// Old_FileConnector fc = null;
	CSVConnector fc = null;
	String sourceName = conf.getSourceName();
	String path = conf.getPath();

	// fc = new Old_FileConnector(sourceName, path, relationName,
	// separator);
	fc = new CSVConnector(conf);

	int id = ProfileTaskFactory.computeTaskId(path, sourceName);
	this.taskId = id;
	this.connector = fc;
    }

    @Override
    public SourceConfig getSourceConfig() {
	return this.config;
    }

    @Override
    public SourceType getSourceType() {
	return SourceType.csv;
    }

    @Override
    public int getTaskId() {
	return taskId;
    }

    @Override
    public Connector getConnector() {
	return connector;
    }

    @Override
    public void close() {
	this.connector.destroyConnector();
    }

    @Override
    public String toString() {
	String sourceName = config.getSourceName() + "/" + config.getRelationName();
	return taskId + " - " + sourceName;
    }

}
