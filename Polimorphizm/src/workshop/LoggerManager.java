package workshop;

public class LoggerManager implements LoggerService{

	private LoggerHead[] logger;
	
	public LoggerManager(LoggerHead ...logger) {
		super();
		this.logger = logger;
	}
	@Override
	public void log() {
		for (LoggerHead logic : logger) {
			logic.log();
		}
		
	}

}
