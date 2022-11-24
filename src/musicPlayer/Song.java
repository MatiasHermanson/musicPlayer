package musicPlayer;

public class Song {
	
	String name;
	double duration;
	
	
	public Song(String name, double duration) {
		this.name=name;
		this.duration=duration;
	}
	
	public Song() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Song name:" + name + ", duration=" + duration + "]";
	}
	
	
}
