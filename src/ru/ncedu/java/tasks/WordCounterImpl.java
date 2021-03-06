package ru.ncedu.java.tasks;

import java.util.*;

/**
 * Created by Sir Nightmare on 08/01/16.
 * Class for word counting
 */
public class WordCounterImpl implements WordCounter {
    private String text;
    private Map<String, Long> numberOfWords = new HashMap<String, Long>();

    public WordCounterImpl() {
    }

    /**
     * Принимает текст для анализа
     *
     * @param text текст для анализа
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return текст, переданный для анализа при последнем вызове метода
     * {@link #setText(String) setText}, или <code>null</code>,
     * если указанный метод еще не вызывался или последний раз вызывался
     * с параметром <code>null</code>
     */
    @Override
    public String getText() {

        return text;
    }

    /**
     * Возвращает {@link Map}&lt;{@link String}, {@link Long}&gt;,
     * сопоставляющую каждому слову количество его вхождений в анализируемый текст.
     * Все возвращаемые слова должны быть приведены к нижнему регистру.
     *
     * @return результат подсчета количеств вхождений слов
     * @throws IllegalStateException если не задан текст для анализа
     *                               (метод {@link #setText(String) setText} еще не вызывался
     *                               или последний раз вызывался с параметром <code>null</code>)
     */
    @Override
    public Map<String, Long> getWordCounts() throws IllegalStateException {
        if (this.text != null) {
            String text = this.text;
            //text = text.replaceAll("[|#.,/:;?—'!\"№%@$~`><^*&(){}\\[\\]_+]?", "");
            text = text.replaceAll("<[\\s]*[\\S]*[\\s]*>", " ");
            text = text.replaceAll("\\{}", "");
            text = text.replaceAll("[\\s]+", " ");
            text = text.toLowerCase();
            String[] wordArray = text.split(" ");
            for (String word : wordArray) {
                if (word != null) {
                    word = word.trim();
                    if (numberOfWords.containsKey(word)) {
                        numberOfWords.put(word, numberOfWords.get(word) + 1);
                    } else {
                        numberOfWords.put(word, 1L);
                    }
                }
            }
            return numberOfWords;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Возвращает список из {@link /Entry Map.Entry}&lt;{@link String}, {@link Long}&gt;,
     * сопоставляющий каждому слову количество его вхождений в анализируемый текст
     * и упорядоченный в прядке убывания количества вхождений слова.<br/>
     * Слова с одинаковым количеством вхождений упорядочиваются в алфавитном порядке (без учета регистра!).<br/>
     * Все возвращаемые слова должны быть приведены к нижнему регистру.
     *
     * @return упорядоченный результат подсчета количеств вхождений слов
     * @throws IllegalStateException если не задан текст для анализа
     *                               (метод {@link #setText(String) setText} еще не вызывался
     *                               или последний раз вызывался с параметром <code>null</code>)
     */
    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() throws IllegalStateException {
        if (this.text != null) {
            return sortWordCounts(numberOfWords);

        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Упорядочивает результат подсчета количеств вхождений слов в порядке убывания количества вхождений.<br/>
     * Слова с одинаковым количеством вхождений упорядочиваются в алфавитном порядке (без учета регистра!).<br/>
     * Реализация этого метода не является обязательной, но если он будет реализован, то реализация
     * метода {@link #getWordCountsSorted()} будет тривиальной.
     *
     * @param orig неупорядоченный результат подсчета
     * @return упорядоченный результат подсчета или <code>null</code>, если <code>orig == null</code>
     */
    @Override
    public List<Map.Entry<String, Long>> sortWordCounts(Map<String, Long> orig) {
        if (orig == null) {
            return null;
        } else {
            List<Map.Entry<String, Long>> list =
                    new LinkedList<>(orig.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
                @Override
                public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                    if ((o1.getValue()).compareTo(o2.getValue()) != 0) {
                        return -1 * (o1.getValue()).compareTo(o2.getValue());
                    } else {
                        return (o1.getKey()).compareTo(o2.getKey());
                    }
                }
            });
            return list;
        }
    }
}
