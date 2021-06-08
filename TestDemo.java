import java.util.*;

public class TestDemo {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/05f97d9b29944c018578d98d7f0ce56e
     * 来源：牛客网
     *
     * Web系统通常会频繁地访问数据库，如果每次访问都创建新连接，性能会很差。为了提高性能，架构师决定复用已经创建的连接。当收到请求，并且连接池中没有剩余可用的连接时，系统会创建一个新连接，当请求处理完成时该连接会被放入连接池中，供后续请求使用。
     *
     * 现在提供你处理请求的日志，请你分析一下连接池最多需要创建多少个连接。
     * 输入描述:
     * 输入包含多组数据，每组数据第一行包含一个正整数n（1≤n≤1000），表示请求的数量。
     *
     * 紧接着n行，每行包含一个请求编号id（A、B、C……、Z）和操作（connect或disconnect）。
     *
     *
     * 输出描述:
     * 对应每一组数据，输出连接池最多需要创建多少个连接。
     * @param args
     *
     * HashMap ---键值对
     * 1. Map是一个接口，不能直接实例化对象，如果要实例化对象只能实例化其实现类TreeMap或者HashMap
     * 2. Map中存放键值对的Key是唯一的，value是可以重复的
     * 3. 在Map中插入键值对时，key不能为空，否则就会抛NullPointerException异常，但是value可以为空
     * 4. Map中的Key可以全部分离出来，存储到Set中来进行访问(因为Key不能重复)。
     * 5. Map中的value可以全部分离出来，存储在Collection的任何一个子集合中(value可能有重复)。
     * 6. Map中键值对的Key不能直接修改，value可以修改，如果要修改key，只能先将该key删除掉，然后再来进行重新插入。
     * V put(K key, V value)  设置 key 对应的 value
     * V remove(Object key)   删除 key 对应的映射关系
     * Set<K> keySet()        返回所有 key 的不重复集合
     * Collection<V> values() 返回所有 value 的可重复集合
     * V get(Object key)      返回 key 对应的 value
     * boolean containsKey(Object key) 判断是否包含 key
     * boolean containsValue(Object value) 判断是否包含 value
     *
     * HashSet --只有值
     * boolean add(E e)  添加元素，但重复元素不会被添加成功
     * void clear()  清空集合
     * boolean contains(Object o) 判断 o 是否在集合中
     * Iterator<E> iterator()  返回迭代器
     * boolean remove(Object o)  删除集合中的 o
     * int size()  返回set中元素的个数
     * boolean isEmpty()  检测set是否为空，空返回true，否则返回false
     */
    public static void main1(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNextInt()) {
                int n = Integer.parseInt(in.next());
                int curLink = 0, maxLink = 0;
                Set<String> linkPool = new HashSet<>();
                for (int i = 0; i < n; ++i) {
                    String name = in.next(), state = in.next();
                    if (!linkPool.contains(name) && "connect".equals(state)) {
                        linkPool.add(name);
                        ++curLink;
                        maxLink = Math.max(curLink, maxLink);
                        continue;
                    }

                    if (linkPool.contains(name) && "disconnect".equals(state)) {
                        --curLink;
                        linkPool.remove(name);
                    }
                }

                System.out.println(maxLink);
            }

            in.close();
        }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/433c0c6a1e604a4795291d9cd7a60c7a
     * 来源：牛客网
     *
     * 工作中，每当要部署一台新机器的时候，就意味着有一堆目录需要创建。例如要创建目录“/usr/local/bin”，就需要此次创建“/usr”、“/usr/local”以及“/usr/local/bin”。好在，Linux下mkdir提供了强大的“-p”选项，只要一条命令“mkdir -p /usr/local/bin”就能自动创建需要的上级目录。
     * 现在给你一些需要创建的文件夹目录，请你帮忙生成相应的“mkdir -p”命令。
     *
     * 输入描述:
     * 输入包含多组数据。
     *
     * 每组数据第一行为一个正整数n(1≤n≤1024)。
     *
     * 紧接着n行，每行包含一个待创建的目录名，目录名仅由数字和字母组成，长度不超过200个字符。
     *
     *
     * 输出描述:
     * 对应每一组数据，输出相应的、按照字典顺序排序的“mkdir -p”命令。
     *
     * 每组数据之后输出一个空行作为分隔。
     * 示例1
     * 输入
     * 3
     * /a
     * /a/b
     * /a/b/c
     * 3
     * /usr/local/bin
     * /usr/bin
     * /usr/local/share/bin
     * 输出
     * mkdir -p /a/b/c
     *
     * mkdir -p /usr/bin
     * mkdir -p /usr/local/bin
     * mkdir -p /usr/local/share/bin
     * @param args
     * string.startsWith("字符串"，数字（决定从哪位开始）) ---用于检测字符串是否以指定的前缀开始。
     * string.contains()---判断子字符串是否存在。
     * string,replace(1,2)----用字符串2取代1
     * string.substring(num1,num2);--取出[num1,num2)之间的值；
     *
     */

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < arr.length; i ++ ) {
                arr[i] = sc.next();
            }
            Arrays.sort(arr);
            List<String> res = new ArrayList<>();
            for (int i = 1; i < arr.length; i ++ ) {
                if( ! arr[i].startsWith(arr[i - 1] + "/")){
                    res.add(arr[i - 1]);
                }
            }
            res.add(arr[n - 1]);
            for (String s:res) {
                System.out.println("mkdir -p " + s);
            }
            System.out.println();
        }
    }

    /**
     * nextInt()和nextLine()一起使用时的注意点,nextLine()会把nextInt()，next()，nextDouble()，nextFloat()的结束换行符作为字符串读入，进而不需要从键盘输入字符串nextLine便已经转向了下一条语句执行。
     * 解决办法：
     * 在每一个nextInt()，next()，nextDouble()，nextFloat()后都加一个nextLine()语句，将它们的结束换行符过滤。
     * @param args
     * 问题描述：
     * 有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。你站在其中一
     * 块黑色的瓷砖上，只能向相邻的黑色瓷砖移动。请写一个程序，计算你总共能够到达多
     * 少块黑色的瓷砖。
     * 输入数据
     * 包括多个数据集合。每个数据集合的第一行是两个整数W 和H，分别表示x 方向
     * 和y 方向瓷砖的数量。W 和H 都不超过20。在接下来的H 行中，每行包括W 个字符。
     * 每个字符表示一块瓷砖的颜色，规则如下
     * 1）‘.’：黑色的瓷砖；
     * 2）‘#’：白色的瓷砖；
     * 3）‘@’：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一
     * 次。
     * 当在一行中读入的是两个零时，表示输入结束。
     * 输出要求
     * 对每个数据集合，分别输出一行，显示你从初始位置出发能到达的瓷砖数(记数时
     * 包括初始位置的瓷砖)。
     * 输入样例
     *
     * 6 9
     * ....#.
     * .....#
     * ......
     * ......
     * ......
     * ......
     * ......
     * #@...#
     * .#..#.
     *
     *
     * 队列使用方式：Queue<Node> queue = new LinkedList<>();
     * 队列可使用函数：add()--入队
     *             ：poll()--出队
     *             ：peek()--查看队首顶元素
     *             : empty()--判断栈是否为空
     *
     */

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            Character[][] map = new Character[m][n];
            Node start = null;
            for (int i = 0; i < m; i++) {
                String s = sc.nextLine();
                for (int j = 0; j <s.length() ; j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@'){
                        start = new Node(i,j);
                    }
                }
            }
            System.out.println(bfs(map,start));
        }

    }

    private static int bfs(Character[][] map,Node start) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        int count = 1;
        queue.add(start);
        visited[start.x][start.y] = true;
        int[][] arr = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for (int i = 0; i <4 ; i++) {
                Node  next = new Node(cur.x + arr[i][0],cur.y +arr[i][1]);
                if(next.x >= 0 && next.y >= 0 && next.x < map.length && next.y < map[0].length && !visited[next.x][next.y]&& map[next.x][next.y] != '#'){
                    count++;
                    queue.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
        return count;
    }
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f72adfe389b84da7a4986bde2a886ec3
     * 来源：牛客网
     *
     * 求字典序在s1和s2之间的，长度在len1到len2的字符串的个数，结果mod 1000007。
     *
     *
     * 输入描述:
     * 每组数据包涵s1（长度小于100），s2（长度小于100），len1（小于100000），len2（大于len1，小于100000）
     *
     *
     * 输出描述:
     * 输出答案。
     * 示例1
     * 输入
     * ab ce 1 2
     * 输出
     * 56
     * @param args
     */
    public static void main4(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char[] array = sc.next().toCharArray();
            char[] brray = sc.next().toCharArray();
            int min = sc.nextInt();
            int max = sc.nextInt();

            int sum = 0;
            for(int i=min; i<=max; i++){
                int suma = 0;
                int sumb = 0;
                for(int j=0; j<array.length; j++){//计算array之前的所有字符串的个数
                    suma = suma + (array[j] - 'a')*(int)Math.pow(26, i-j-1);
                }

                for(int j=0; j<brray.length; j++){//计算brray之前所有字符串的个数
                    sumb = sumb + (brray[j] - 'a')*(int)Math.pow(26, i-j-1);
                }

                sum = sum + sumb - suma;//一次循环中sumb - suma 就是两个字符串之间的个数
            }
            sum--;//由于第一个字符计算在内，因此要去掉
            System.out.println(sum%1000007);
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9ae56e5bdf4f480387df781671db5172
     * 来源：牛客网
     *
     * 我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。子串中的字符不一定在原字符串中连续。
     * 例如字符串“abcfbc”和“abfcab”，其中“abc”同时出现在两个字符串中，因此“abc”是它们的公共子序列。此外，“ab”、“af”等都是它们的字串。
     * 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
     *
     * 输入描述:
     * 输入包含多组数据。
     *
     * 每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
     *
     *
     * 输出描述:
     * 对应每组输入，输出最长公共子序列的长度。
     * 示例1
     * 输入
     * abcfbc abfcab
     * programming contest
     * abcd mnp
     * 输出
     * 4
     * 2
     * 0
     * @param args
     * 3. 题目解析
     * 题目要求比较简单：获取两个字符串的最长公共的子序列，注意：子序列即两个字符串中公共的字符，但不一定连续。动态规划求解最长公共子序列(LCS): 对于母串X=<x1,x2,⋯,xm>, Y=<y1,y2,⋯,yn>，求LCS。
     *
     * 假设：假设Z=<z1,z2,⋯,zk>是X与Y的LCS， 我们观察到：
     *
     * 1. 如果xm=yn，则zk=xm=yn，有Zk−1是Xm−1与Yn−1的LCS
     * 2. 如果xm≠yn，则Zk是Xm与Yn−1的LCS，或者是Xm−1与Yn的LCS
     */

    public static void main5(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] str = in.nextLine().split(" ");
            int resLen = longA(str[0], str[1]);
            System.out.println(resLen);
        }
    }
    private static int longA(String a,String b){
        int m = a.length();
        int n = b.length();
        if(m==0||n==0){
            return 0;
        }
        int[][] res = new int[m+1][n+1];
        for(int i = 0; i <= m;i++){
            for(int j = 0;j<= n;j++){
                if(i ==0 || j == 0){
                    res[i][j] = 0;
                }else if(a.charAt(i-1) == b.charAt(j-1)){
                    res[i][j] = res[i-1][j-1] + 1;
                }else{
                    res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        }
        return res[m][n];
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/ceb89f19187b4de3997d9cdef2d551e8
     * 来源：牛客网
     *
     * 上图是一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
     * NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分。
     *
     * 输入描述:
     * 输入包含多组数据。
     *
     * 每组数据第一行包含一个正整数n（1≤n≤1024）。
     *
     * 紧接着n行，每行包含一个电话号码，电话号码仅由连字符“-”、数字和大写字母组成。
     * 没有连续出现的连字符，并且排除连字符后长度始终为7（美国电话号码只有7位）。
     *
     *
     * 输出描述:
     * 对应每一组输入，按照字典顺序输出不重复的标准数字形式电话号码，即“xxx-xxxx”形式。
     *
     * 每个电话号码占一行，每组数据之后输出一个空行作为间隔符。
     * @param args
     *
     * Collections.sort(arrayList) 这里用到了Collections类中的sort方法。--Collections，这是Java官方提供的针对集合类（ArrayList,LinkedList,Queue,set,Stack）的工具类
     * 常用方法：size();isEmpty;contains();add();remove()
     */

    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String str2 = "222333444555666777788899991234567890";
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            List<String> list = new ArrayList<>();
            for(int i = 0;i < n ;i++){
                String str3 = in.next();
                str3 = str3.replace("-","");
                String result = "";
                for(int j = 0; j < 7;j++){
                    //result = result + str2.charAt(str1.indexOf(str3.charAt(j) + ""));
                    result+=str2.charAt(str1.indexOf(str3.charAt(j)+""));
                }
                result = result.substring(0,3) +"-" + result.substring(3,7);
                if(!list.contains(result)){
                    list.add(result);
                }
            }
            Collections.sort(list);
            for(String s : list){
                System.out.println(s);
            }
            System.out.println();
        }
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/11cc498832db489786f8a03c3b67d02c
     * 来源：牛客网
     *
     * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
     *
     * 输入描述:
     * 每个测试输入包含2个整数,n和m
     *
     *
     * 输出描述:
     * 按每个组合的字典序排列输出,每行输出一种组合
     *
     *
     */

    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;

        while(sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            dfs(1, m, n);
            for(ArrayList<Integer> l : res) {
                int i = 0;
                for(; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }

    public static void dfs(int index, int count, int n) {
        if(count == 0) {
            res.add(new ArrayList<>(list));
        }
        else {
            for(int i = index; i <= count && i <= n; i++) {
                list.add(i);
                dfs(i + 1, count - i, n);
                list.remove(list.size() - 1);
            }
        }
    }

}

