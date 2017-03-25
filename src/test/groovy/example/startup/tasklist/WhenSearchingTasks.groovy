package example.startup.tasklist

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Unroll

@Narrative("""ユーザーはタスクを登録しておいて、あとから見返したい。
直近ではやらないタスクなどを覚えておきたくないので、直近のタスクだけ見ることが重要になる。
でも、たまには来月以降のタスクを見返したいこともある。""")
class WhenSearchingTasks extends Specification {

  @Unroll
  def "should show : #expected"() {
    given: "タスクを読み込む"
    def tl = TaskList.load(expected + UUID.randomUUID().toString())

    when: "タスクを検索する"
    def ts = tl.search(word)
    then: "対象のタスクを取得できる"
    ts*.title == expected

    where:
    word                   | expected
    "exist-task"           | ["exist-task-1", "exist-task-2"]
    "duplicate-name"       | ["duplicate-name1", "duplicate-name2", "duplicate-name2"]
    "${UUID.randomUUID()}" | []
  }

}