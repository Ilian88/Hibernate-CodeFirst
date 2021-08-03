import entities.hospital.Diagnose;
import entities.hospital.Medicament;
import entities.hospital.Patient;
import entities.hospital.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        EntityManager entityManager = Persistence.createEntityManagerFactory("test")
                .createEntityManager();


        //TODO Uncomment for ex.4
        //exerciseFour(entityManager);


    }

    private static void exerciseFour(EntityManager entityManager) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter patient's first name:");
        String patientFirstName = reader.readLine();

        System.out.println("Enter patient's last name");
        String patientLastName = reader.readLine();

        System.out.println("Enter patient's address");
        String patientAddress = reader.readLine();

        System.out.println("Enter patient's email");
        String patientEmail = reader.readLine();

        System.out.println("Enter date of birth in format - Year-Month-Day");
        LocalDate date = LocalDate.parse(reader.readLine());

        System.out.println("Enter patient's picture url");
        String patientUrl = reader.readLine();

        System.out.println("Does the patient has medical insurance , if yes type 'yes' ");
        Boolean hasInsurance = Boolean.valueOf(reader.readLine());

        Patient patient = new Patient();
        patient.setFirstName(patientFirstName);
        patient.setLastName(patientLastName);
        patient.setAddress(patientAddress);
        patient.setEmail(patientEmail);
        patient.setPictureUrl(patientUrl);
        patient.setHasMedicalInsurance(hasInsurance);
        patient.setDateOfBirth(date);

        Visitation visitation = new Visitation();

        System.out.println("Enter visitation date in format - Year-Month-Day");
        LocalDate visitDate = LocalDate.parse(reader.readLine());

        System.out.println("Enter comments on visitation");
        String comments = reader.readLine();
        visitation.setDate(visitDate);
        visitation.setComments(comments);
        visitation.setPatient(patient);

        System.out.println("Enter name of diagnose:");
        String diagnoseName = reader.readLine();
        System.out.println("Enter diagnose comments:");
        String diagnoseComments = reader.readLine();
        Diagnose diagnose = new Diagnose();

        diagnose.setName(diagnoseName);
        diagnose.setComments(diagnoseComments);
        diagnose.setPatient(patient);

        System.out.println("Enter prescribed medicament");
        String medicamentName = reader.readLine();

        Medicament medicament = new Medicament();
        medicament.setName(medicamentName);
        medicament.setDiagnose(diagnose);

        entityManager.getTransaction().begin();

        entityManager.persist(patient);
        entityManager.persist(visitation);
        entityManager.persist(diagnose);
        entityManager.persist(medicament);

        entityManager.getTransaction().commit();
    }
}
