package org.msdg.zhilian;

public class Position {
        String position;
        String company;
        String salary;
        String place;
        String detail;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "detail='" + detail + '\'' +
                    ", place='" + place + '\'' +
                    ", salary='" + salary + '\'' +
                    ", company='" + company + '\'' +
                    ", position='" + position + '\'' +
                    '}';
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        if (position != null ? !position.equals(position1.position) : position1.position != null) return false;
        if (company != null ? !company.equals(position1.company) : position1.company != null) return false;
        if (salary != null ? !salary.equals(position1.salary) : position1.salary != null) return false;
        if (place != null ? !place.equals(position1.place) : position1.place != null) return false;
        return detail != null ? detail.equals(position1.detail) : position1.detail == null;

    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}