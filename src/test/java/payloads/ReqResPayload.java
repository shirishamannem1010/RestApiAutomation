package payloads;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReqResPayload {

	  private String name;
	    private String job;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public ReqResPayload(String name, String job) {
			this.name = name;
			this.job = job;
		}
	   public ReqResPayload() {}
	    
}
