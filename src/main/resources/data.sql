-- Insert Classes into class
INSERT INTO class (id, name, health_dice, default_class_skills_count)
VALUES (UUID(), 'BARBARIAN', 'D12', 2),
       (UUID(), 'BARD', 'D8', 3),
       (UUID(), 'CLERIC', 'D8', 2),
       (UUID(), 'DRUID', 'D8', 2),
       (UUID(), 'FIGHTER', 'D10', 2),
       (UUID(), 'MONK', 'D8', 2),
       (UUID(), 'PALADIN', 'D10', 2),
       (UUID(), 'RANGER', 'D10', 3),
       (UUID(), 'ROGUE', 'D8', 4),
       (UUID(), 'SORCERER', 'D6', 2),
       (UUID(), 'WARLOCK', 'D8', 2),
       (UUID(), 'WIZARD', 'D6', 2);


-- Insert Skills into skill
INSERT INTO skill (id, name, ability_score)
VALUES (UUID(), 'ATHLETICS', 'STRENGTH'),
       (UUID(), 'ACROBATICS', 'DEXTERITY'),
       (UUID(), 'SLEIGHT_OF_HAND', 'DEXTERITY'),
       (UUID(), 'STEALTH', 'DEXTERITY'),
       (UUID(), 'ARCANA', 'INTELLIGENCE'),
       (UUID(), 'HISTORY', 'INTELLIGENCE'),
       (UUID(), 'INVESTIGATION', 'INTELLIGENCE'),
       (UUID(), 'NATURE', 'INTELLIGENCE'),
       (UUID(), 'RELIGION', 'INTELLIGENCE'),
       (UUID(), 'ANIMAL_HANDLING', 'WISDOM'),
       (UUID(), 'INSIGHT', 'WISDOM'),
       (UUID(), 'MEDICINE', 'WISDOM'),
       (UUID(), 'PERCEPTION', 'WISDOM'),
       (UUID(), 'SURVIVAL', 'WISDOM'),
       (UUID(), 'DECEPTION', 'CHARISMA'),
       (UUID(), 'INTIMIDATION', 'CHARISMA'),
       (UUID(), 'PERFORMANCE', 'CHARISMA'),
       (UUID(), 'PERSUASION', 'CHARISMA');

-- Insert Class-DefaultSkill relationships into class_default_skills table

-- BARBARIAN
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'BARBARIAN'),
        (SELECT id FROM skill WHERE name = 'ANIMAL_HANDLING')),
       ((SELECT id FROM class WHERE name = 'BARBARIAN'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'BARBARIAN'),
        (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'BARBARIAN'), (SELECT id FROM skill WHERE name = 'NATURE')),
       ((SELECT id FROM class WHERE name = 'BARBARIAN'),
        (SELECT id FROM skill WHERE name = 'PERCEPTION')),
       ((SELECT id FROM class WHERE name = 'BARBARIAN'), (SELECT id FROM skill WHERE name = 'SURVIVAL'));

-- BARD (Bard has all skills)
INSERT INTO class_default_skills (class_id, skill_id)
SELECT (SELECT id FROM class WHERE name = 'BARD'), id
FROM skill;

-- CLERIC
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'CLERIC'), (SELECT id FROM skill WHERE name = 'HISTORY')),
       ((SELECT id FROM class WHERE name = 'CLERIC'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'CLERIC'), (SELECT id FROM skill WHERE name = 'MEDICINE')),
       ((SELECT id FROM class WHERE name = 'CLERIC'), (SELECT id FROM skill WHERE name = 'PERSUASION')),
       ((SELECT id FROM class WHERE name = 'CLERIC'), (SELECT id FROM skill WHERE name = 'RELIGION'));

-- DRUID
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'DRUID'),
        (SELECT id FROM skill WHERE name = 'ANIMAL_HANDLING')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'ARCANA')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'MEDICINE')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'NATURE')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'PERCEPTION')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'RELIGION')),
       ((SELECT id FROM class WHERE name = 'DRUID'), (SELECT id FROM skill WHERE name = 'SURVIVAL'));

-- FIGHTER
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'ACROBATICS')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'),
        (SELECT id FROM skill WHERE name = 'ANIMAL_HANDLING')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'HISTORY')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'),
        (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'PERCEPTION')),
       ((SELECT id FROM class WHERE name = 'FIGHTER'), (SELECT id FROM skill WHERE name = 'SURVIVAL'));

-- MONK
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'ACROBATICS')),
       ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'HISTORY')),
       ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'RELIGION')),
       ((SELECT id FROM class WHERE name = 'MONK'), (SELECT id FROM skill WHERE name = 'STEALTH'));

-- PALADIN
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'PALADIN'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'PALADIN'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'PALADIN'),
        (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'PALADIN'), (SELECT id FROM skill WHERE name = 'MEDICINE')),
       ((SELECT id FROM class WHERE name = 'PALADIN'), (SELECT id FROM skill WHERE name = 'PERSUASION')),
       ((SELECT id FROM class WHERE name = 'PALADIN'), (SELECT id FROM skill WHERE name = 'RELIGION'));

-- RANGER
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'RANGER'),
        (SELECT id FROM skill WHERE name = 'ANIMAL_HANDLING')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'RANGER'),
        (SELECT id FROM skill WHERE name = 'INVESTIGATION')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'NATURE')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'PERCEPTION')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'STEALTH')),
       ((SELECT id FROM class WHERE name = 'RANGER'), (SELECT id FROM skill WHERE name = 'SURVIVAL'));

-- ROGUE
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'ACROBATICS')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'ATHLETICS')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'DECEPTION')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'INVESTIGATION')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'PERCEPTION')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'PERFORMANCE')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'PERSUASION')),
       ((SELECT id FROM class WHERE name = 'ROGUE'),
        (SELECT id FROM skill WHERE name = 'SLEIGHT_OF_HAND')),
       ((SELECT id FROM class WHERE name = 'ROGUE'), (SELECT id FROM skill WHERE name = 'STEALTH'));

-- SORCERER
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'SORCERER'), (SELECT id FROM skill WHERE name = 'ARCANA')),
       ((SELECT id FROM class WHERE name = 'SORCERER'), (SELECT id FROM skill WHERE name = 'DECEPTION')),
       ((SELECT id FROM class WHERE name = 'SORCERER'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'SORCERER'),
        (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'SORCERER'), (SELECT id FROM skill WHERE name = 'PERSUASION')),
       ((SELECT id FROM class WHERE name = 'SORCERER'), (SELECT id FROM skill WHERE name = 'RELIGION'));

-- WARLOCK
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'WARLOCK'), (SELECT id FROM skill WHERE name = 'ARCANA')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'), (SELECT id FROM skill WHERE name = 'DECEPTION')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'), (SELECT id FROM skill WHERE name = 'HISTORY')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'),
        (SELECT id FROM skill WHERE name = 'INTIMIDATION')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'),
        (SELECT id FROM skill WHERE name = 'INVESTIGATION')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'), (SELECT id FROM skill WHERE name = 'NATURE')),
       ((SELECT id FROM class WHERE name = 'WARLOCK'), (SELECT id FROM skill WHERE name = 'RELIGION'));

-- WIZARD
INSERT INTO class_default_skills (class_id, skill_id)
VALUES ((SELECT id FROM class WHERE name = 'WIZARD'), (SELECT id FROM skill WHERE name = 'ARCANA')),
       ((SELECT id FROM class WHERE name = 'WIZARD'), (SELECT id FROM skill WHERE name = 'HISTORY')),
       ((SELECT id FROM class WHERE name = 'WIZARD'), (SELECT id FROM skill WHERE name = 'INSIGHT')),
       ((SELECT id FROM class WHERE name = 'WIZARD'),
        (SELECT id FROM skill WHERE name = 'INVESTIGATION')),
       ((SELECT id FROM class WHERE name = 'WIZARD'), (SELECT id FROM skill WHERE name = 'MEDICINE')),
       ((SELECT id FROM class WHERE name = 'WIZARD'), (SELECT id FROM skill WHERE name = 'RELIGION'));
