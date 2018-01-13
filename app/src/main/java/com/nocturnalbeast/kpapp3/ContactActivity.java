package com.nocturnalbeast.kpapp3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    private EditText etUserName = null;
    private EditText etUserPass = null;
    private EditText etSubject = null;
    private EditText etTexts = null;
    private View fieldsContainer = null;
    private View loadingContainer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        etUserName = (EditText) findViewById(R.id.et_usr_name);
        etUserPass = (EditText) findViewById(R.id.et_usr_pass);
        etSubject = (EditText) findViewById(R.id.et_subject);
        etTexts = (EditText) findViewById(R.id.etml_text_content);
        fieldsContainer = findViewById(R.id.sv_fields_container);
        loadingContainer = findViewById(R.id.ly_loading_container);
        showFields();
    }

    public void sendMail(View v) {
        new SendMailTask().execute((Void[]) null);
    }

    public void hideFields() {
        fieldsContainer.setVisibility(View.GONE);
        loadingContainer.setVisibility(View.VISIBLE);
    }

    public void showFields() {
        fieldsContainer.setVisibility(View.VISIBLE);
        loadingContainer.setVisibility(View.GONE);

    }

    private class SendMailTask extends AsyncTask<Void, Void, Void> {

        Exception error = null;
        boolean readyToSend = false;
        String username = "";
        String pass = "";
        String subject = "";
        String texts = "";
        private static final String EMAIL_REXP = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)" +
                "*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        private String[] extractEmails(final String all){
            Pattern pattern = Pattern.compile(EMAIL_REXP);
            StringTokenizer tokenizer = new StringTokenizer(all, ";");
            List<String> mailList = new ArrayList<String>();

            String currentMail;
            while (tokenizer.hasMoreElements()) {
                currentMail = (String) tokenizer.nextElement();
                if (pattern.matcher(currentMail.trim()).matches()){
                    mailList.add(currentMail);
                }
            }
            return mailList.toArray(new String[0]);
        }

        private void sendMail() throws Exception {

            //String[] tos = extractEmails(etToAddresses.getText().toString());
            String[] tos = {"karthikpadmakumar21@gmail.com"};
            // 1 - Create one instance
            MailSender m = new MailSender();

            // 2 - Set addressees
            m.setCredentials(username, pass)
                    .setToAddresses(tos);

            // 3 - Set the content of the mail
            m.setSubject(subject).setMailText(texts);

            // 4 - Attach files if you want
            //m.attachFile("AttachedFile.jpg", Environment.getExternalStorageDirectory().getPath() + "/DCIM/100MEDIA/IMAG0001.jpg")
            //      .attachFile("AttachedFile2.jpg", Environment.getExternalStorageDirectory().getPath() + "/DCIM/100MEDIA/IMAG0001.jpg");

            // 5 - Set properties to use and send
            m.useMailPropertiesGMail().send();
        }

        @Override
        protected void onPreExecute() {
            username = etUserName.getText().toString();
            pass = etUserPass.getText().toString();
            subject = etSubject.getText().toString();
            texts = etTexts.getText().toString();

            if ((username.length() < 1)
                    || (pass.length() < 1)
                    || (subject.length() < 1)
                    || (texts.length() < 1)) {
                Toast.makeText(getApplicationContext(), "ERROR: Fill all the filelds", Toast.LENGTH_LONG).show();
            } else {
                super.onPreExecute();
                hideFields();
                readyToSend = true;
            }
        }

        @Override
        protected Void doInBackground(Void... params) {
            if (readyToSend) {
                try {
                    sendMail();
                } catch (Exception e) {
                    error = e;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (error == null) {
                Toast.makeText(getApplicationContext(), "Message sent :-D", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "ERROR sending: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
            showFields();
            readyToSend = false;
        }

    }

}
