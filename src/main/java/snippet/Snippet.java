package snippet;

public class Snippet {
	public static void main(String[] args) {
		<plugin>
		        <groupId>org.apache.maven.plugins</groupId>
		        <artifactId>maven-surefire-plugin</artifactId>
		        <version>3.0.0-M9</version>
		        <configuration>
		          <suiteXmlFiles>
		            <suiteXmlFile>testng.xml</suiteXmlFile>
		          </suiteXmlFiles>
		        </configuration>
		      </plugin>
	}
}

