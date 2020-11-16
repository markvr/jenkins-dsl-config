import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

@Builder(builderStrategy = SimpleStrategy, prefix = '')
class JobBuilder {

  // Name to give the job.
  String name

  // Docker image to run.
  String image

  // Docker tag to run
  String tag

  // Schedule to run job on
  String schedule

  Job build(DslFactory dslFactory) {
    dslFactory.job(name) {
      description("Job '$name' running '$image:$tag'")

      triggers {
        cron(schedule)
      }
      steps {
        shell("docker run ghcr.io/markvr/$image:$tag")
      }
    }
  }
}
