public class Student {
        int age;
        String name;

        @Override
        public boolean equals(final Object o) {
                if (this == o) {
                        return true;
                }
                if (o == null || this.getClass() != o.getClass()) {
                        return false;
                }

                final Student student = (Student) o;

                if (this.age != student.age) {
                        return false;
                }
                return this.name != null ? this.name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
                int result = this.age;
                result = 45 * result + (this.name != null ? this.name.hashCode() : 0);
                return result;
        }
}