const vocabForm = document.getElementById('vocabForm');
const wordsContainer = document.getElementById('wordsContainer');
const btnRandom = document.getElementById('btnRandom');
const randomLevel = document.getElementById('randomLevel');
const randomResult = document.getElementById('randomResult');

const API_URL = '/api/vocab';

document.addEventListener('DOMContentLoaded', fetchWords);

vocabForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const newWord = {
        englishTerm: document.getElementById('englishTerm').value,
        spanishTranslation: document.getElementById('spanishTranslation').value,
        definition: document.getElementById('definition').value,
        synonyms: document.getElementById('synonyms').value,
        partOfSpeech: document.getElementById('partOfSpeech').value,
        targetLevel: document.getElementById('targetLevel').value,
        exampleSentence: document.getElementById('exampleSentence').value
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newWord)
        });

        if (response.ok) {
            alert("✨ Word saved successfully!");
            vocabForm.reset();
            fetchWords(); 
        } else {
            alert("❌ Failed to save! Status: " + response.status);
        }
    } catch (error) {
        alert("🚨 Cannot connect to Java server! Make sure Spring Boot is running.");
        console.error('Error:', error);
    }
});

async function fetchWords() {
    try {
        const response = await fetch(API_URL);
        const words = await response.json();
        
        wordsContainer.innerHTML = ''; 
        
        words.forEach(word => {
            const card = document.createElement('div');
            card.className = 'word-card';
            
            const cleanLevel = word.targetLevel.replace(/_/g, ' ');
            const synonymsHtml = word.synonyms ? `<div class="synonyms">🔗 Synonyms: ${word.synonyms}</div>` : '';

            card.innerHTML = `
                <div class="word-header">
                    <h3>${word.englishTerm} <span style="font-size: 0.9rem; color: #a0aab2; font-weight: normal;">(${word.partOfSpeech})</span></h3>
                    <span class="level-badge">${cleanLevel}</span>
                </div>
                <div class="translation">🇲🇽 ${word.spanishTranslation}</div>
                <div class="definition">📖 <strong>Def:</strong> ${word.definition}</div>
                ${synonymsHtml}
                <div class="example">"${word.exampleSentence}"</div>
            `;
            
            wordsContainer.appendChild(card);
        });
    } catch (error) {
        console.error('Error loading vocabulary:', error);
    }
}

// --- RANDOM BUTTON LOGIC ---
btnRandom.addEventListener('click', async () => {
    const level = randomLevel.value;
    const url = level === 'ALL' ? `${API_URL}/random` : `${API_URL}/random/${level}`;
    
    try {
        const response = await fetch(url);
        
        if (response.status === 204 || response.headers.get("content-length") === "0") {
            throw new Error("No words");
        }
        
        const word = await response.json();
        const cleanLevel = word.targetLevel.replace(/_/g, ' ');
        const synonymsHtml = word.synonyms ? `<div class="synonyms">🔗 Synonyms: ${word.synonyms}</div>` : '';
        
        randomResult.innerHTML = `
            <div class="word-header">
                <h3>${word.englishTerm} <span style="font-size: 0.9rem; color: #a0aab2; font-weight: normal;">(${word.partOfSpeech})</span></h3>
                <span class="level-badge">${cleanLevel}</span>
            </div>
            <div class="translation">🇲🇽 ${word.spanishTranslation}</div>
            <div class="definition">📖 <strong>Def:</strong> ${word.definition}</div>
            ${synonymsHtml}
            <div class="example">"${word.exampleSentence}"</div>
        `;
        randomResult.classList.remove('hidden');

    } catch (error) {
        randomResult.innerHTML = `<p style="color: #5c7c64; text-align:center; font-weight: 600;">No words registered for this level yet 👀</p>`;
        randomResult.classList.remove('hidden');
    }
});