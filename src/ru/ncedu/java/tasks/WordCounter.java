package ru.ncedu.java.tasks;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


//ЦЕЛЬ ЗАДАЧИ - разобраться с интерфейсом java.util.Map и его реализациями.
//        Дополнительно: разобраться с API для сортировки.
//        Дополнительно: разобраться с использованием регулярных выражений в Java
//        или хотя бы с другим API для работы со строками.
//
//        ЗАДАНИЕ
//        Подсчитать количества вхождений слов в тексте без учета регистра символов.
//
//Common requirements:
//        Your class must be placed to the same package as the interface: ru.ncedu.java.tasks.
//        Your class must be named WordCounterImpl.
//        Your class must be public and implement the given interface, i.e. the class definition must be as follows:
//public class WordCounterImpl implements WordCounter
//{ ... }
//Your class must have a public no-argument constructor that means either the default constructor (the absence of any constructors in your code) or the presence of the following code:
//public WordCounterImpl(){ ... }
//        Your class must not have compilation errors (write your code in IDE).
//        Instantiation with the no-argument constructor must not fail (it's recommended to test it in main() method).
//


/**
 * ЦЕЛЬ ЗАДАЧИ - разобраться с интерфейсом java.util.Map и его реализациями.<br/>
 * Дополнительно: разобраться с API для сортировки.<br/>
 * Дополнительно: разобраться с использованием регулярных выражений в Java
 *  или хотя бы с другим API для работы со строками.<br/>
 * <br/>
 * ЗАДАНИЕ<br/>
 * Подсчитать количества вхождений слов в тексте без учета регистра символов.<br/>
 * <br/>
 * ТРЕБОВАНИЯ<br/>
 * Словом считается любая последовательность символов, выделенная произвольным
 * количеством пробелов, символов табуляции и переводов строк.<br/>
 * НЕОБХОДИМО подсчитать количества вхождений слов в тексте без учета регистра символов
 * (слова 'Программа' и 'программа' считаются одним и тем же словом!).<br/>
 * ДОПОЛНИТЕЛЬНО возможно упорядочивание результатов подсчетов в порядке
 * убывания количества вхождений слова,
 * а также исключение из рассмотрения слов, заключенных внутри &lt;&gt;.<br/>
 * <br/>
 * ПРИМЕЧАНИЯ:<br/>
 * - В HTML &gt; - это > (больше), &lt; - это < (меньше), а комментарии пишутся в таком "странном"
 *  виде, чтобы они корректно отображались в HTML, который из них генерируется через javadoc).<br/>
 *  То есть, вышеприведенную фразу следует читать: "заключенных внутри <>".<br/>
 * - Данная задача не требует убирать из слов знаки препинания (.,;:-), однако при желании
 *   их можно убрать (класс будет тестироваться текстами, не содержащими этих знаков).<br/>
 * - Для самопроверки можно взять длинный текст, например, из http://www.gnu.org/licenses/lgpl-3.0.txt<br/>
 *
 * @author Andrey Shevtsov
 */
public interface WordCounter
{
    /**
     * Принимает текст для анализа
     * @param text текст для анализа
     */
    void setText (String text);
    /**
     * @return текст, переданный для анализа при последнем вызове метода
     * {@link #setText(java.lang.String) setText}, или <code>null</code>,
     * если указанный метод еще не вызывался или последний раз вызывался
     * с параметром <code>null</code>
     */
    String getText ();
    /**
     * Возвращает {@link Map}&lt;{@link String}, {@link Long}&gt;,
     * сопоставляющую каждому слову количество его вхождений в анализируемый текст.
     * Все возвращаемые слова должны быть приведены к нижнему регистру.
     * @return результат подсчета количеств вхождений слов
     * @throws IllegalStateException если не задан текст для анализа
     * (метод {@link #setText(java.lang.String) setText} еще не вызывался
     * или последний раз вызывался с параметром <code>null</code>)
     */
    Map<String, Long> getWordCounts() throws IllegalStateException;
    /**
     * Возвращает список из {@link Entry Map.Entry}&lt;{@link String}, {@link Long}&gt;,
     * сопоставляющий каждому слову количество его вхождений в анализируемый текст
     * и упорядоченный в прядке убывания количества вхождений слова.<br/>
     * Слова с одинаковым количеством вхождений упорядочиваются в алфавитном порядке (без учета регистра!).<br/>
     * Все возвращаемые слова должны быть приведены к нижнему регистру.
     * @return упорядоченный результат подсчета количеств вхождений слов
     * @throws IllegalStateException если не задан текст для анализа
     * (метод {@link #setText(java.lang.String) setText} еще не вызывался
     * или последний раз вызывался с параметром <code>null</code>)
     */
    List<Map.Entry<String, Long>> getWordCountsSorted() throws IllegalStateException;
    /**
     * Упорядочивает результат подсчета количеств вхождений слов в порядке убывания количества вхождений.<br/>
     * Слова с одинаковым количеством вхождений упорядочиваются в алфавитном порядке (без учета регистра!).<br/>
     * Реализация этого метода не является обязательной, но если он будет реализован, то реализация
     *  метода {@link #getWordCountsSorted()} будет тривиальной.
     * @param orig неупорядоченный результат подсчета
     * @return упорядоченный результат подсчета или <code>null</code>, если <code>orig == null</code>
     */
    List<Map.Entry<String, Long>> sortWordCounts (Map<String, Long> orig);
}
